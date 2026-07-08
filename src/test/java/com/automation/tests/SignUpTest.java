package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.SignUpPage;
import com.automation.util.DataProviderUtil;
import com.automation.util.TestUtil;

public class SignUpTest extends TestBase {

	@Test(
			dataProvider = "signUpData",
			dataProviderClass = DataProviderUtil.class)
	public void verifySignUp(
			String name) {

		HomePage home =
				new HomePage(driver);

		home.clickSignupLogin();

		SignUpPage signUp =
				new SignUpPage(driver);

		String email =
				TestUtil.generateEmail();

		signUp.signUp(
				name,
				email);

		System.out.println(
				"Signup completed for : "
						+ name);
	}
}