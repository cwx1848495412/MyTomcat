package servlet.spring;

import annotation.Component;
import annotation.RequestMapping;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/27 11:03
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Component
@RequestMapping("lifecycle")
public class LifeCycleController {

    @RequestMapping("test")
    public String test(){
        System.out.println("lifecycle test");

        return "lifecycle test over";
    }
}
