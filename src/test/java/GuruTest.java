import com.yst.dao.GuruDAO;
import com.yst.entity.Guru;
import com.yst.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuruTest extends BasicTest{
    @Autowired
    private GuruDAO guruDAO;
    @Autowired
    private GuruService guruService;
    @Test
    public void insert(){
       guruDAO.insert(new Guru("35","rt","rt","rt"));

    }

    @Test
    public void update(){
       guruDAO.update(new Guru("34","wyyw","wyyw","wyyw"));

    }

    @Test
    public void delte(){
        guruDAO.delete("39");

    }
    @Test
    public void queryAll(){
        //List<Guru> list = guruService.findByPage(1,10);
        List<Guru> list = guruDAO.queryByPage(1,10);
        System.out.println(list);
    }
}
