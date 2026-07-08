package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;


public class HomePageTest extends TestBase {

	
	@Test
	public void verifySignupLoginClick() {

		HomePage hp = new HomePage(driver);

		hp.clickSignupLogin();

		LoginPage login =
				new LoginPage(driver);

		Assert.assertTrue(
				login.isLoginPageDisplayed());
	}
	
}