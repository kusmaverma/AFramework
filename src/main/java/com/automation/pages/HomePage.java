package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.reports.ExtentReportManager;
import com.automation.util.WaitUtil;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
	WebElement signupLogin;

	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logoutLink;

	public void clickSignupLogin() {

		WaitUtil.waitForElementToBeClickable(
				driver,
				signupLogin);

		signupLogin.click();

		ExtentReportManager
				.getTest()
				.info("Clicked Signup/Login link");
	}

	public void clickLogout() {

	    WaitUtil.waitForElementToBeClickable(driver, logoutLink);

	    logoutLink.click();

	    ExtentReportManager
	            .getTest()
	            .info("Clicked Logout");
	}
}