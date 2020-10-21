package filter;

import io.Request;
import io.Response;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/15 09:47
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public interface Filter {
    /**
     *
     * @param request
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    boolean doFilter(Request request);
}

