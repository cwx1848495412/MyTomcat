package filter_upgrade;

import io.Request;
import io.Response;
import servlet.Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:19
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class FilterChain {

    private List<Filter> chain = new LinkedList<Filter>();

    private Integer index = 0;

    private Servlet servlet;

    private void add(Filter filter) {
        chain.add(filter);
    }

    public FilterChain(Servlet servlet) {
        this.servlet = servlet;
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("FilterUpgrade.properties");
            properties.load(in);

            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                String className = properties.getProperty(key);
//                System.out.println("添加顺序--------" + className);
                Class<Filter> clazz = (Class<Filter>) Class.forName(className);
                // 根据类创建对象
                Filter filter = clazz.newInstance();// MyFilter

                chain.add(filter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
//        // 到达尽头
//        if (filterChain.index == filterChain.chain.size()) return false;
//
//        Filter filter = filterChain.chain.get(filterChain.index++);
//
//        return filter.doFilter(request, response, filterChain);
//    }


    public boolean doFilter(Request request, Response response) {
        // 到达尽头
        if (index == chain.size()) {
            try {
                servlet.service(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;// 返回值无所谓了 结束责任链
        }

        Filter filter = chain.get(index++);

        return filter.doFilter(request, response, this);
    }


}
