package servlet;

import io.Request;
import io.Response;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:26
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class MyServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        System.out.println("--Servlet TODO--");
        response.write("GET MyTomcat");
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        response.write("POST MyTomcat");
    }
}
