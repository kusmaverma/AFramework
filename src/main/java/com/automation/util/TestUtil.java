package com.automation.util;

public class TestUtil {

	public static String generateEmail() {

		return "auto"
				+ System.currentTimeMillis()
				+ "@gmail.com";
	}
}