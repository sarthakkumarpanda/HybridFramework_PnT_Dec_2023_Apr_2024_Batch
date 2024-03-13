package com.tutorialsNinja.Utilities;

import java.util.Date;

public class Util {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME_WAIT = 10;
	public static final int SCRIPT_TIME_WAIT = 10;

	
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@gmail.com";
	}
}
