package filter_upgrade;

import io.Request;
import io.Response;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/15 09:47
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class LoginFilter implements Filter {

//    【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】

    /**
     * @param request
     * @param response
     * @param filterChain
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("LoginFilter request处理");

        if (true) {
//            return false;//有意义
        }

        filterChain.doFilter(request, response);

        System.out.println("LoginFilter response处理");

        return true;// 无意义
    }
}
