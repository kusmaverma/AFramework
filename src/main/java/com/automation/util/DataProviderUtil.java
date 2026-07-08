package com.automation.util;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {

		return ExcelUtil.getTestData(
				"LoginData");
	}
	
	@DataProvider(name = "signUpData")
	public Object[][] signUpData() {

		return ExcelUtil.getTestData(
				"SignUpData");
	}
}