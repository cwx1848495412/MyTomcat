package servlet;

import io.Request;
import io.Response;

import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:49
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public interface Servlet {

    String METHOD_GET = "GET";
    String METHOD_POST = "POST";

    void service(Request request, Response response) throws IOException;
}
