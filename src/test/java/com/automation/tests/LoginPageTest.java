package com.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.util.DataProviderUtil;
import com.automation.util.ScreenshotUtil;

public class LoginPageTest extends TestBase {

	private static final Logger logger =
			LogManager.getLogger(LoginPageTest.class);

	@Test(
			dataProvider = "loginData",
			dataProviderClass = DataProviderUtil.class)
	public void verifyValidLogin(
			String email,
			String password,
			String expected) {

		logger.info("Starting Login Test");

		logger.info(
				"Email : " + email +
				" Password : " + password +
				" Expected : " + expected);

		HomePage home = new HomePage(driver);

		home.clickSignupLogin();

		logger.info("Clicked Signup/Login");

		LoginPage login = new LoginPage(driver);

		logger.info("Login data fetched from Excel");

		login.login(email, password);

		if (expected.equalsIgnoreCase("Valid")) {

			Assert.assertTrue(
					login.isLogoutDisplayed(),
					"Valid Login Failed");

			logger.info("Valid Login Successful");

		} else {

			Assert.assertTrue(
					login.isErrorMessageDisplayed(),
					"Invalid Login Validation Failed");

			logger.info(
					"Invalid Login Error Message Displayed");
		}

		ScreenshotUtil.captureScreenshot(
				driver,
				"LoginPageTest");

		logger.info("Screenshot captured");
	}
}