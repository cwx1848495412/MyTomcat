package filter;

import io.Request;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/15 09:47
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class MyFilter implements Filter{

    @Override
    public boolean doFilter(Request request) {
        System.out.println("我的过滤器-处理私人逻辑");

        return true;
    }
}
