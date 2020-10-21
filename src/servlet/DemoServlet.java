package servlet;

import io.Request;
import io.Response;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:54
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class DemoServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        response.write("Demo DoGet");
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        response.write("Demo DoPost");
    }
}
