package com.yst.vo;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date>{
//用于给页面响应时的日期处理
	@Override
	public Date convert(String dateString) {
		Date date=null;
		
		try {
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			date = sd.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}

}
