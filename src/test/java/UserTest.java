import com.yst.dao.UserDAO;
import com.yst.entity.User;
import com.yst.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserTest extends BasicTest{
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;
    @Test
    public void page(){
        List<User> list = userDAO.queryByPage(0,2);
        for (User user : list) {
            System.out.println(user);
        }

    }
    @Test
    public void one(){
        User user = userService.findOne("3");

            System.out.println(user);


    }
    @Test
    public  void delete(){
        userDAO.delete("2");
    }
    @Test
    public  void update(){
        userService.modify(new User("3","3呀呀","33呀呀","33呀呀","3","3","3","3","3","3","3","活跃",new Date()));
    }
    @Test
    public  void insert(){
            userService.add(new User("xx","第几个呢","第几个呢","第几个呢real","123456","3","城市","城市","头像","个签","性别","集合",new Date()));
    }
}
