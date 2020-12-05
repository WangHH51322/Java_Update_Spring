import com.wang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 21:24
 */
public class MyTest {
    public static void main(String[] args) {

        //在 new ClassPathXmlApplicationContext 的时候,Spring容器中的对象就已经被创建,空参构造什么的都已经有了
        //后面的 context.getBean() 只是调用被创建好的对象
        //注意:输出的结果中有一句: "这是一个空参构造,我是一位老师" ,而Teacher这个对象并没有被调用,但是却已经没创建,有了空参构造,证实了上面的话
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        user.show();
    }
}
