package com.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupUtil {

	public static void closePopup(WebDriver driver) {

		try {

			WebElement closeButton =
					driver.findElement(
							By.xpath("//div[contains(text(),'Close')]"));

			closeButton.click();

			System.out.println("Popup Closed");

		} catch (Exception e) {

			System.out.println("Popup Not Displayed");
		}
	}
}