package com.yst.controller;

import com.yst.entity.Chapter;
import com.yst.service.ChapterService;
import com.yst.util.AudioUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
//上传音频
 @RequestMapping("add")
    public @ResponseBody Map<String,Object>
 add(Chapter chapter, MultipartFile upload, HttpSession session){
        Map<String,Object> results=new HashMap<String,Object>();
     System.out.println("---------oraginal------"+upload.getOriginalFilename());
        try {
            String fileName=session.getServletContext().getRealPath("/upload/chapter") + "/" + upload.getOriginalFilename();
            System.out.println("---------------lujing------------------------"+fileName);
            upload.transferTo(new File(fileName));
            chapter.setChapterDownloadPath("upload/album/"+upload.getOriginalFilename());
            Double size = AudioUtil.getSize(fileName);
            chapter.setChapterSize(size);
            String duration = AudioUtil.getDuration(fileName);
            chapter.setTitle(upload.getOriginalFilename());
            chapter.setChapterDuration(duration);
            System.out.println("----------------chapter----------"+chapter);
            chapterService.add(chapter);
            results.put("success", true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return  results;
    }



    @RequestMapping("download")
    public  @ResponseBody  void download(HttpSession session, HttpServletResponse response, String  fileName) throws Exception{
        String realPath = session.getServletContext().getRealPath("/upload/chapter");
        System.out.println("-----------realpath---------------"+realPath);
        //1.通过输入流 读入下载的文件                    将用户要下载的名字获取到           自带的方法   将文件读成字节数组
        byte[] downloadFile = FileUtils.readFileToByteArray(new File(realPath+"/"+fileName));
        //2.通过response获得输出流   输出
        //设置下载方式是 下载文件，热不是直接打开  在struts2中是在配置文件中写的
        //attachment是指以附件形式打开  filename=xx.txt是指打开的名字
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
        OutputStream os = response.getOutputStream();
        os.write(downloadFile);
        os.flush();
        IOUtils.closeQuietly(os);
    }
}
