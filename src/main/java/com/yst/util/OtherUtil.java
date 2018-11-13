package com.yst.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Iterator;

public class OtherUtil {

        public static void main(String[] args){
            File source=new File("C:\\Users\\杨少婷\\Music\\林和夜 - 相聚万年树 (PV片段版).mp3");
            Encoder encoder=new Encoder();
            try{
                MultimediaInfo m = encoder.getInfo(source);
                long ls = m.getDuration();
                long duration = ls/1000;
                System.out.println(ls/60000+':'+(ls/1000-ls/60000*60));

                System.out.println("-----------length--------"+source.length());
                Long la=source.length();
                Double d=la.doubleValue();
                Double ds=(Double)(d/1024)/1024;
                System.out.println(ds);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public static void a(HttpRequest request)throws Exception{
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile(iter.next());
                String fileOldName = file.getOriginalFilename();
                long duration = 0;
                CommonsMultipartFile cf = (CommonsMultipartFile) file;
                DiskFileItem fi = (DiskFileItem) cf.getFileItem();
                File source = fi.getStoreLocation();
                Encoder encoder = new Encoder();
                MultimediaInfo m = encoder.getInfo(source);
                long ls = m.getDuration();
                duration = ls / 1000;

            }

        }
    }


