import com.wang.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 17:00
 */
public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象都在Spring中管理,如果要使用,直接去里面取出来
        //这个对象在Spring中都统称为Bean,所以要getBean(),然后根据id获取指定对象
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

    }
}
