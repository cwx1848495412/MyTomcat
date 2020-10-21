package filter_upgrade;

import io.Request;
import io.Response;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/15 09:47
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class MyFilter implements Filter {

    /**
     * @param request
     * @param response
     * @param filterChain
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("MyFilter request处理");

        filterChain.doFilter(request, response);

        System.out.println("MyFilter response处理");

        return true;
    }
}
