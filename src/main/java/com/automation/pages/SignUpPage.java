package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.reports.ExtentReportManager;
import com.automation.util.WaitUtil;

public class SignUpPage {

	WebDriver driver;

	// Constructor
	public SignUpPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(name = "name")
	private WebElement txtName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement btnSignUp;

	// Actions

	public void enterName(String name) {

		txtName.sendKeys(name);

		ExtentReportManager
				.getTest()
				.info("Entered Name");
	}

	public void enterEmail(String email) {

		txtEmail.sendKeys(email);

		ExtentReportManager
				.getTest()
				.info("Entered Email");
	}

	public void clickSignUpButton() {

		try {

			WaitUtil.waitForElementToBeClickable(
					driver,
					btnSignUp);

			btnSignUp.click();

			ExtentReportManager
					.getTest()
					.info("Clicked Sign Up Button");

		} catch (Exception e) {

			JavascriptExecutor js =
					(JavascriptExecutor) driver;

			js.executeScript(
					"arguments[0].click();",
					btnSignUp);

			ExtentReportManager
					.getTest()
					.info("Clicked Sign Up Button using JavaScriptExecutor");
		}
	}
	
	// Reusable Method

	public void signUp(String name, String email) {

		enterName(name);

		enterEmail(email);

		clickSignUpButton();
	}
}