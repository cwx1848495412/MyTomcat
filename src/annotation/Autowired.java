package annotation;

import java.lang.annotation.*;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/24 22:39
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
public @interface Autowired {
    String value() default "";
}
