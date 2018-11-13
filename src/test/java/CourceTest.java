import com.yst.dao.CourceDAO;
import com.yst.entity.Cource;
import com.yst.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourceTest extends BasicTest{
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourceDAO courceDAO;
    @Test
    public void queryAll(){
        List<Cource> cources = courceDAO.queryAll();
        System.out.println(cources);

    }
}
