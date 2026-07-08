package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.util.DataProviderUtil;
import com.automation.util.PopupUtil;

public class LogoutTest extends TestBase {

	@Test(
			dataProvider = "loginData",
			dataProviderClass = DataProviderUtil.class)
	public void verifyLogout(
			String email,
			String password,
			String expected) {

		// Execute only for valid users
		if (!expected.equalsIgnoreCase("Valid")) {

			System.out.println(
					"Skipping Invalid Login Data");

			return;
		}

		HomePage home =
		        new HomePage(driver);

		home.clickSignupLogin();

		LoginPage login =
		        new LoginPage(driver);

		login.login(
		        email,
		        password);

		// Verify login completed successfully
		Assert.assertTrue(
		        login.isLogoutDisplayed(),
		        "Login Failed. Logout link not displayed.");

		// Close popup if it appears
		PopupUtil.closePopup(driver);

		// Recreate HomePage after successful login
		home = new HomePage(driver);

		home.clickLogout();

		// Verify Login Page displayed after logout
		Assert.assertTrue(
		        login.isLoginPageDisplayed(),
		        "Logout Failed");

		System.out.println("Logout successful");
	}
}