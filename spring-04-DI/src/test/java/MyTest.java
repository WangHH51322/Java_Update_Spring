import com.wang.pojo.Student;
import com.wang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/6 16:13
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());

        /*
        Student{
        name='小王',
        address=Address{
            Address='安徽'
            },
        books=[平凡的世界1,平凡的世界2,平凡的世界3],
        hobbys=[音乐,游戏,电影],
        card={
            身份证=3121234567,
            学生证=123321456,
            银行卡=62170017456,
            饭卡=4321
            },
        games=[CS:GO,LOL,WOW],
        wife='',
        info={
            password=newpassword,
            driver=jdbc,
            url=jdbc:mysql://localhost:3306/wang_last?allowMultiQueries=true,
            username=root
            }
        }
         */
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user.toString());
        System.out.println(user2.toString());
    }
}
