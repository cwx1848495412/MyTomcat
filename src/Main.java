import java.io.IOException;

/**
 * @Auther: 苏察哈尔丶灿
 * @Date: 2020/9/2 20:41
 * @Slogan: 我自横刀向天笑，笑完我就去睡觉。
 */
public class Main {
    public static void main(String[] args) {
        try {
            Server.startServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
