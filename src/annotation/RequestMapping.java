package annotation;

import java.lang.annotation.*;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/24 22:39
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequestMapping {
    String value() default "";
}
