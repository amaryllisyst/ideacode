import com.yst.dao.AdminDAO;
import com.yst.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BasicTest{
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminDAO adminDAO;
    @Test
    public void register(){
        adminService.register(new com.yst.entity.Admin("15ddf5","123","123","123"));
    }
    @Test
    public void login(){
        adminDAO.login("1","1");

    }
}
