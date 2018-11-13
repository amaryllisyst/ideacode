import com.yst.dao.MenuDAO;
import com.yst.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuTest extends BasicTest{
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuDAO menuDAO;
    @Test
    public void queryAll(){


    }
}
