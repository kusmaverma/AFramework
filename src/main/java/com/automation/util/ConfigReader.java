package com.automation.util;

import java.util.Properties;
import java.io.InputStream;

public class ConfigReader {

	private Properties prop;

	public ConfigReader() {

		prop = new Properties();

		try {

			InputStream fis =
					getClass()
					.getClassLoader()
					.getResourceAsStream(
							"config.properties");

			prop.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getBrowser() {

		return prop.getProperty("browser");
	}

	public String getUrl() {

		return prop.getProperty("url");
	}
}