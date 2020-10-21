package servlet.spring;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/25 00:27
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Component
@RequestMapping("loop")
public class BService {

    @Autowired
    private AService aService;

    @RequestMapping("b_test")
    public String bTest() {
        System.out.println("我是 BService 的方法,将要调用 A");
        aService.a();

        return "BService over";
    }

    public void b() {
        System.out.println("我是 BService 的方法 b");
    }
}
