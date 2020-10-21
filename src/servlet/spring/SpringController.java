package servlet.spring;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import io.Request;
import io.Response;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:26
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Component
@RequestMapping("spring")
public class SpringController {

    @Autowired
    private MapperService mapperService;

    @RequestMapping("test")
    public String test() {
        System.out.println("I am Spring Test!!!");

        mapperService.autowired();

        return "I am Spring Test Response!!!";
    }
}
