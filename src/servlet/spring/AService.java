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
public class AService {

    @Autowired
    private BService bService;

    @RequestMapping("a_test")
    public String aTest(){
        System.out.println("我是 AService 的方法,将要调用 B method b");
        bService.b();

        return "AService over";
    }


    public void a() {
        System.out.println("我是 AService 的方法 a");
    }
}
