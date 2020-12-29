import com.wang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 15:19
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理 代理的是接口 : 注意点
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }
}
