package servlet;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import io.Request;
import io.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/24 21:45
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class DispatcherServlet extends HttpServlet {

    private final Map<String, Object> IOC = new HashMap<String, Object>();

    private Properties contextConfig = new Properties();

    private List<String> classNameList = new LinkedList<String>();

    private Map<String, Method> handlerMapping = new HashMap<String, Method>();

    public DispatcherServlet() {
        this.init();
        System.out.println("DispatcherServlet constructor....");
    }

    public void init() {
        // 加载配置文件
        doLoadConfig();

        // 扫描相关类
        doScanner(contextConfig.getProperty("scanPackage"));

        // 实例化
        doInstance();

        // 完成依赖注入
        doAutowired();

        // 初始化建立映射关系
        doInitHandlerMapping();
    }

    private void doLoadConfig() {

        try (InputStream in = new FileInputStream("Dispatcher.properties")) {
//            InputStream in = this.getClass()
//                    .getClassLoader()
//                    .getResourceAsStream("Dispatcher.properties")
//            InputStream in = new FileInputStream("Dispatcher.properties")

            contextConfig.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void doScanner(String scanPackage) {

        URL urlResource = this.getClass()
                .getResource("/" + scanPackage
                        .replaceAll("\\.", "/"));

        // 拿到目录
        File directory = new File(urlResource.getFile());

        Arrays.stream(directory.listFiles()).forEach(file -> {

            if (file.isDirectory()) {
                // 如果是目录 继续扫描子包
                doScanner(scanPackage + "." + file.getName());
            } else {
                // 如果文件后缀不是class 不做处理
                if (!file.getName().endsWith(".class")) return;

                String className = scanPackage + "." + file.getName()
                        .replace(".class", "");

                classNameList.add(className);
            }

        });

    }

    private void doInstance() {
        if (classNameList.isEmpty()) return;

        classNameList.stream().forEach(className -> {
            try {
                Class clazz = Class.forName(className);
                String simpleName = clazz.getSimpleName();

                if (!clazz.isAnnotationPresent(Component.class)) return;

                Object o = clazz.newInstance();

                IOC.put(simpleName, o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private void doAutowired() {
        if (IOC.isEmpty()) return;

        for (Map.Entry<String, Object> entry : IOC.entrySet()) {

            Object currentObject = entry.getValue();

            Field[] fields = currentObject.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowired.class)) continue;
//                Autowired autowired = field.getAnnotation(Autowired.class);
                // 可以获取注解的值 做一些事情

                // IOC用简单类名获取
                String className = field.getType().getSimpleName();

                try {
                    // 对象可能是 private
                    // 所以需要用反射打破私有化封装
                    field.setAccessible(true);
                    // 给currentObject对象的field字段赋值一个IOC.get(className)实例对象
                    field.set(currentObject, IOC.get(className));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    private void doInitHandlerMapping() {
        if (IOC.isEmpty()) return;

        for (Map.Entry<String, Object> entry : IOC.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(Component.class)) continue;

            String baseUrl = "";
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                baseUrl = clazz.getAnnotation(RequestMapping.class).value();
            }

            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(RequestMapping.class)) continue;

                String requestUrl = method.getAnnotation(RequestMapping.class).value();

                // 注解没加 /
                String url = ("/" + baseUrl + "/" + requestUrl).replaceAll("/+", "/");

                handlerMapping.put(url, method);
            }

        }
    }


    @Override
    public void doGet(Request request, Response response) throws IOException {

        // 完成路由调度
        doDispatcher(request, response);
    }

    private void doDispatcher(Request request, Response response) {
        String requestUrl = request.getRequestUrl().replaceAll("/+", "/");


        if (!handlerMapping.containsKey(requestUrl)) {
            try {
                response.write("404 Not Found!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        Method method = handlerMapping.get(requestUrl);

        try {
            // 对象在容器里面通过类名去拿
            // 类名这会已经丢了
            // 获取类名
            String className = method.getDeclaringClass().getSimpleName();

            Object invokeResult = method.invoke(IOC.get(className));

            try {
                response.write(invokeResult.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
//            method.invoke(className, null);
//            这块 要实现传参 可以如下 细做
//            Parameter[] parameters = method.getParameters();
//            parameters[0].isAnnotationPresent("@Param/@Pathvariable/等等等等");
//            巴拉巴拉 一大堆逻辑 先不做

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void doPost(Request request, Response response) throws IOException {
        doGet(request, response);
    }
}
