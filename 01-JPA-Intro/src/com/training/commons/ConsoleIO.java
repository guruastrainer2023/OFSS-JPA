package com.training.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleIO {
	
	public String readStringInputFromConsole(){
		String str=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			str=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public byte readByteInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Byte.parseByte(str);
	}
	
	public short readShortInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Short.parseShort(str);
	}
	
	public int readIntInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Integer.parseInt(str);
	}
	
	public long readLongInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Long.parseLong(str);
	}
	
	public float readFloatInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Float.parseFloat(str);
	}
	
	
	public double readDoubleInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return Double.parseDouble(str);
	}
	
	public char readCharInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		return str.charAt(0);
	}
	
	public boolean readBooleanInputFromConsole(){
		String str=null;
		str=readStringInputFromConsole();
		if(str.equalsIgnoreCase("yes"))
			return true;
		
		if(str.charAt(0)=='Y' || str.charAt(0)=='y')
			return true;
		
		return false;
		
	}
	
	public Date readDateInputFromConsole(){
		String str=readStringInputFromConsole();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date date=null;
		try {
			date=sdf.parse(str);
		} catch (ParseException e) {
			System.out.println("Invalid Date Format");
		}
		return date;
	}
	

}
