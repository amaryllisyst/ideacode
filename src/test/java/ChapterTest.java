import com.yst.dao.ChapterDAO;
import com.yst.entity.Album;
import com.yst.entity.Chapter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ChapterTest extends BasicTest {
    @Autowired
    private ChapterDAO chapterDAO;
    @Test
    public  void insert(){
        chapterDAO.insert(new Chapter("qe3eqwsxxxxssssewq6","烂东西",6.0,"7","6",new Date(),new Album("1")));
       // new Chapter("6","6",6.0,"7","6",new Date(),new Album(""));
    }
   /* @Test
    public  void update(){
        chapterDAO.update(new Chapter("6","6",
                6336.0,666.0,"6",new Date(),new Album("1","alubum1",new Date(),"11",3,"蔼蔼","请求","上师")));
    }
    @Test
    public  void delete(){
        chapterDAO.delete("5");
    }
    @Test
    public  void queryTotals() {
        Long aLong = chapterDAO.queryCount("1");
        System.out.println(aLong);
    }
    @Test
    public  void queryAll(){
        List<Chapter> list = chapterDAO.queryAll();
        for (Chapter chapter : list) {
            System.out.println(chapter);
        }
    }*/

}
