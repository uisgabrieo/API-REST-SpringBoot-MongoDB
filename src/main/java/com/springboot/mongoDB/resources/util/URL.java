package com.springboot.mongoDB.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String textData, LocalDate defaultValue) {
		
		System.out.println("textData: " + textData);
		System.out.println("defaultValue: " + defaultValue);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			System.out.println("textData: " + textData);
			return LocalDate.parse(textData, fmt);
		} catch (Exception e) {
			System.out.println("defaultValue: " + defaultValue);
			return defaultValue;
		}
	}
	
}
