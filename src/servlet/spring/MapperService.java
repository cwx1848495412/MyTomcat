package servlet.spring;

import annotation.Component;

import java.util.HashMap;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/25 00:27
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Component
public class MapperService {
    public void autowired(){
        System.out.println("我是自动注入的方法，看看能否实现！");
    }
}
