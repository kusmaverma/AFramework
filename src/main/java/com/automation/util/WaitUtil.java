package com.automation.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	public static void waitForElementToBeVisible(
			WebDriver driver,
			WebElement element) {

		WebDriverWait wait =
				new WebDriverWait(
						driver,
						Duration.ofSeconds(10));

		wait.until(
				ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(
			WebDriver driver,
			WebElement element) {

		WebDriverWait wait =
				new WebDriverWait(
						driver,
						Duration.ofSeconds(10));

		wait.until(
				ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForUrlContains(
	        WebDriver driver,
	        String value) {

	    WebDriverWait wait =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(10));

	    wait.until(
	            ExpectedConditions.urlContains(value));
	}
}