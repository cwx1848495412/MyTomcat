package filter;

import filter.Filter;
import io.Request;
import servlet.Servlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:19
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class FilterChain {

    private List<Filter> chain = new LinkedList<Filter>();

    private void add(Filter filter) {
        chain.add(filter);
    }

    public FilterChain() {
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("Filter.properties");
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

    public void doFilter(Request request) {
        for (Filter filter : chain) {
//            【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】
            final boolean pass = filter.doFilter(request);

            if (!pass) {
                break;
            }
        }
    }

}
