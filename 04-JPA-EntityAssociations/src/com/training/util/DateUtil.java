package com.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = sdf.parse(strDate);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String getFormattedDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String result = sdf.format(date);
		return result;

	}
	
	public static java.sql.Date getSQLDate(java.util.Date dateToConvert){
		java.sql.Date result=new java.sql.Date(dateToConvert.getTime());
		return result;
		
	}
	
	public static java.util.Date getUtilDate(java.sql.Date dateToConvert){
		java.util.Date result=new java.util.Date(dateToConvert.getTime());
		return result;
		
	}

}
