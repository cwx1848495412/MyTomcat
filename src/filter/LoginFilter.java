package filter;

import io.Request;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/15 09:47
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class LoginFilter implements Filter{

//    【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】

    @Override
    public boolean doFilter(Request request) {
        System.out.println("登录过滤器-筛选了一大批人");

        // false -1
        return true;
    }
}
