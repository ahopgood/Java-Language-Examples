package com.alexander.java.examples.java7;

public class SwitchStatements {
	
	public static void main(String[] args){
		
	}
	
	public static String jan = "January";
	public static String feb = "February";
	public static String march = "March";
	public static String april = "April";
	public static String may = "May";
	public static String june = "June";
	public static String july = "July";
	public static String aug = "August";
	public static String sept = "September";
	public static String oct = "October";
	public static String nov = "November";
	public static String dec = "December";
	
//	public static String match = "match";
//	public static String noMatch = "no match";
	
	public static int stringSwitch(String arg){
		switch (arg){
			case "April": case "June": 
			case "September": case "November" :
				return 30;
			case "January": case "March": 
			case "May": case "July": 
			case "August": case "December":
			case "October":
				return 31;
			case "February":
				return 28;
		default:
			return 30;
		}
	}
	
}
