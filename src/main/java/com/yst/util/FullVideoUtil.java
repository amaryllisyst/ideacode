package com.yst.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
//过程
public class FullVideoUtil {
        public static Double getSize(String fileName) throws  Exception{//大小
            File source = new File(fileName);
            Encoder encoder = new Encoder();
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            long duration = ls / 1000;
            Long la = source.length();
            Double d = la.doubleValue();
            Double ds = (Double) (d / 1024) / 1024;//这是内存大小
            return ds;
        }
        public static String getDuration(String fileName)throws Exception{//时长
            File source = new File(fileName);
            Encoder encoder = new Encoder();
            MultimediaInfo fileSize = encoder.getInfo(source);
            long ls = fileSize.getDuration();
            return ls/60000+":"+(ls/1000-ls/60000*60);

        }

    }


