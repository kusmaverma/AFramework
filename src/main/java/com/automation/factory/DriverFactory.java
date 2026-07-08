package com.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver =
			new ThreadLocal<>();

	public static WebDriver initDriver() {

		ConfigReader config =
				new ConfigReader();

		String browser =
				config.getBrowser();

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver.set(new FirefoxDriver());

		} else if (browser.equalsIgnoreCase("edge")) {

			driver.set(new EdgeDriver());

		} else {

			throw new RuntimeException(
					"Invalid Browser Name : "
							+ browser);
		}

		driver.get().manage().window().maximize();

		return driver.get();
	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void quitDriver() {

		if (driver.get() != null) {

			driver.get().quit();

			driver.remove();
		}
	}
}