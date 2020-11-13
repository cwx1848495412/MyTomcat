package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:14
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class Response {
    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>" + str + "<h1>")
                .append("</body>")
                .append("</html>");
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
    }

    public void close() throws IOException {
        this.outputStream.close();
    }
}
