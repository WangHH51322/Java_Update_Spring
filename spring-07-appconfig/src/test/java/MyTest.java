import com.wang.config.MyConfig;
import com.wang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 21:44
 */
public class MyTest {
    public static void main(String[] args) {
        /*
        如果完全使用了配置类方式去做,则需要
        使用 new AnnotationConfigApplicationContext() 获取配置类的上下文,通过配置类的class对象加载!
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User newUser = context.getBean("newUser", User.class);
        System.out.println(newUser.getName());
    }
}
