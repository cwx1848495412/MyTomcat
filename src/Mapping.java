import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:19
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class Mapping {

    private static HashMap<String, String> mapping = new HashMap<String, String>();

    static {
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("Route.properties");
            properties.load(in);

            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                mapping.put(key, properties.getProperty(key));
//                System.out.println(key);
//                System.out.println(properties.getProperty(key));;
//                System.out.println("---------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getClassNameByUrl(String url) {

        // 配且只配 dispatcher 偷个懒 直接写死
//        return "servlet.DispatcherServlet";
        return mapping.get(url);
    }

}
