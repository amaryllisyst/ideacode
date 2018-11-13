import com.yst.util.AudioUtil;
import org.junit.Test;

public class testMp3 {
    @Test
    public void test1() throws Exception{
        String fileName="C:\\Users\\杨少婷\\Music\\马良 - 往后余生 (Demo).mp3";
        //时长
      // String duration = AudioUtil.getDuration(fileName);
       // System.out.println("----------时长-----------"+duration);
//

        //内存大小
      Double size = AudioUtil.getSize(fileName);
       System.out.println("----内存大小"+size);
    }
}
