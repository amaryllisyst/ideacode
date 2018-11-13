package com.yst.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class AudioUtil {
    public static Double getSize(String fileName) throws  Exception{//内存大小
        File source = new File(fileName);
        Long length = source.length();
        Double size = (length.doubleValue() / 1024) / 1024;
        return (double)Math.round(size*100)/100;
    }
    public static String getDuration(String fileName)throws Exception{//时长
        File source = new File(fileName);
        Encoder encoder = new Encoder();
        MultimediaInfo fileSize = encoder.getInfo(source);
        long ls = fileSize.getDuration();
        return ls/60000+":"+((ls/1000-ls/60000*60));

    }
}
