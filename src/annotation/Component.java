package annotation;

import java.lang.annotation.*;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/24 22:31
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
}
