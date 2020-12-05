import com.wang.dao.UserDaoJdbcImpl;
import com.wang.dao.UserDaoMySqlImpl;
import com.wang.service.UserService;
import com.wang.service.UserServiceImpl;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 11:49
 */
public class MyTest {
    public static void main(String[] args) {

        //用户实际调用的是业务层,dao层用户接触不到
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoMySqlImpl());
        userService.getUser();
    }
}
