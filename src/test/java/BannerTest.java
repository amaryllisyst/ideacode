import com.yst.dao.BannerDAO;
import com.yst.entity.Banner;
import com.yst.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerTest extends BasicTest{
@Autowired
    BannerService bannerService;
@Autowired
    BannerDAO bannerDAO;
@Test
    public void  queryAll(){
    List<Banner> list = bannerService.findByPage(1,2);
    System.out.println(list);
}
@Test
    public void  queryByPage(){
    List<Banner> list = bannerDAO.queryByPage(0,3);
    System.out.println(list);
}
@Test
    public void  delete(){
    bannerDAO.delete("1");

}
@Test
    public void  queryOne(){
    Banner banner = bannerService.queryOne("1");
    System.out.println(banner);

}
@Test
    public void  update(){
  bannerService.modify(new Banner("2","信息xx顺风车","信息xx","信息xx","想",new Date()));

}
@Test
    public void  insert(){
    bannerService.add(new Banner("211","信息","信息","信息","想",new Date()));

}

}
