package servlet;

import io.Request;
import io.Response;

import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:21
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public abstract class HttpServlet implements Servlet {

    public abstract void doGet(Request request, Response response) throws IOException;

    public abstract void doPost(Request request, Response response) throws IOException;


    public void service(Request request, Response response) throws IOException {

        if (METHOD_GET.equals(request.getRequestMethod())) {
            doGet(request, response);
        }

        if (METHOD_POST.equals(request.getRequestMethod())) {
            doPost(request, response);
        }

    }
}
