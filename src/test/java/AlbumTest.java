import com.yst.dao.AlbumDAO;
import com.yst.entity.Album;
import com.yst.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumTest extends BasicTest{

    @Autowired
    private AlbumService albumService;
    @Autowired
    private  AlbumDAO albumDAO;
    @Test
    public void register(){
        albumService.add(new Album("5345","alubum1",
                new Date(),"11",3,"x嘻嘻嘻",
                "嘻嘻嘻","2222"));

    }
  //  @Test
  //  public void update(){
     //   albumDAO.update(new Album("1","alubum的标题",new Date(),"11",3,"蔼蔼","请求","上师"));
  //  }
    @Test
    public void delete(){
        albumDAO.delete("2");
    }
    @Test
    public  void query(){
        List<Album> list = albumDAO.queryAll();
        for (Album album : list) {
            System.out.println(album);
            System.out.println();
            System.out.println();
        }
    }

}
