import com.yst.dao.ArticleDAO;
import com.yst.entity.Article;
import com.yst.entity.Guru;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ArticleTest extends  BasicTest{
    @Autowired
    private ArticleDAO articleDAO;
    @Test
    public  void queryAll(){
        List<Article> list = articleDAO.queryAll();
        for (Article lists : list) {
            System.out.println(lists);
        }
    }
    @Test
    public  void queryPage(){
        List<Article> list = articleDAO.queryByPage(0,2);
        for (Article lists : list) {
            System.out.println(lists);
        }
    }

    @Test
    public void insert(){
        articleDAO.insert(new Article("5","ww","ww","www",new Date(),new Guru("34","syy")));
    }
    @Test
    public void update(){
        articleDAO.update(new Article("5","上师","w是是是","三生三世",new Date(),new Guru("34","上师啊")));
    }
    @Test
    public void  delete(){
        articleDAO.delete("5");
    }
};
