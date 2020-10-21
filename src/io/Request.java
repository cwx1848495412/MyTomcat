package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:06
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class Request {

    private String requestMethod;

    private String requestUrl;

    public Request(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[32];

        int len = 0;

        String str = "";

        if ((len = inputStream.read(buffer)) > 0 ){
            str = new String(buffer,0,len);
        }

        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
