package com.automation.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(
			WebDriver driver,
			String testName) {

		String path =
				System.getProperty("user.dir")
				+ "/Screenshots/"
				+ testName
				+ ".png";

		TakesScreenshot ts =
				(TakesScreenshot) driver;

		File src =
				ts.getScreenshotAs(
						OutputType.FILE);

		File dest =
				new File(path);

		try {

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}
}