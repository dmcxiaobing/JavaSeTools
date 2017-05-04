package com.qq986945193.javasetools.utils;

import java.util.Date;

public class MD5Utils {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(DateUtils.getDate(new Date())+" "+DateUtils.getTime(new Date()));
		System.out.println(DateUtils.getCurrentStrDateBySpecifiedFormatType("yyyy-MM-dd hh:mm:ss"));
	}

}
