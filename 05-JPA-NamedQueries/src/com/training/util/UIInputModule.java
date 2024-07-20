package com.training.util;

import java.util.Date;

public class UIInputModule {
	
	static public byte readByteWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		byte temp=new ConsoleIO().readByteInputFromConsole();
		return temp;
	}
	
	static public short readShortWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		short temp=new ConsoleIO().readShortInputFromConsole();
		return temp;
	}
	
	static public int readIntWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		int temp=new ConsoleIO().readIntInputFromConsole();
		return temp;
	}
	
	static public long readLongWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		long temp=new ConsoleIO().readLongInputFromConsole();
		return temp;
	}
	
	static public float readFloatWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		float temp=new ConsoleIO().readFloatInputFromConsole();
		return temp;
	}
	
	static public double readDoubleWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		double temp=new ConsoleIO().readDoubleInputFromConsole();
		return temp;
	}
	
	static public char readCharWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		char temp=new ConsoleIO().readCharInputFromConsole();
		return temp;
	}
	
	static public boolean readBooleanWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		boolean temp=new ConsoleIO().readBooleanInputFromConsole();
		return temp;
	}
	
	static public String readStringWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		String temp=new ConsoleIO().readStringInputFromConsole();
		return temp;
	}
	
	static public Date readDateWithPrompt(String prompt){
		System.out.printf("\n\t\t%-40s : ", prompt);
		Date temp=new ConsoleIO().readDateInputFromConsole();
		return temp;
	}
	
}
