package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.reports.ExtentReportManager;
import com.automation.util.WaitUtil;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),' Logout')]")
	private WebElement logoutLink;

	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
	private WebElement loginErrorMessage;

	public boolean isLoginPageDisplayed() {

		return emailTextBox.isDisplayed();
	}

	public void enterEmail(String email) {

		emailTextBox.sendKeys(email);

		ExtentReportManager
				.getTest()
				.info("Entered Email");
	}

	public void enterPassword(String password) {

		passwordTextBox.sendKeys(password);

		ExtentReportManager
				.getTest()
				.info("Entered Password");
	}

	public void clickLoginButton() {

		try {

			WaitUtil.waitForElementToBeClickable(
					driver,
					loginButton);

			loginButton.click();

			ExtentReportManager
					.getTest()
					.info("Clicked Login Button");

		} catch (Exception e) {

			JavascriptExecutor js =
					(JavascriptExecutor) driver;

			js.executeScript(
					"arguments[0].click();",
					loginButton);

			ExtentReportManager
					.getTest()
					.info("Clicked Login Button using JavaScriptExecutor");
		}
	}

	public void login(
			String email,
			String password) {

		enterEmail(email);

		enterPassword(password);

		clickLoginButton();
	}

	public boolean isLogoutDisplayed() {

	    try {

	        WaitUtil.waitForElementToBeVisible(
	                driver,
	                logoutLink);

	        return logoutLink.isDisplayed();

	    } catch (Exception e) {

	        return false;
	    }
	}
	

	public boolean isErrorMessageDisplayed() {

	    try {

	        WaitUtil.waitForElementToBeVisible(driver, loginErrorMessage);

	        return loginErrorMessage.isDisplayed();

	    } catch (Exception e) {

	        return false;
	    }
	}
}