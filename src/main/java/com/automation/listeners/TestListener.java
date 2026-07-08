package com.automation.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.automation.factory.DriverFactory;
import com.automation.reports.ExtentReportManager;
import com.automation.util.ScreenshotUtil;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Execution Started");
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentReportManager.createTest(result.getName());

		System.out.println(
				"Executing : "
						+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentReportManager
				.getTest()
				.pass("Test Passed Successfully");

		System.out.println(
				"PASSED : "
						+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver =
				DriverFactory.getDriver();

		String screenshotPath =
				ScreenshotUtil.captureScreenshot(
						driver,
						result.getName());

		try {

			ExtentReportManager
					.getTest()
					.fail(
							result.getThrowable(),
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											screenshotPath)
									.build());

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println(
				"FAILED : "
						+ result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentReportManager
				.getTest()
				.skip("Test Skipped");

		System.out.println(
				"SKIPPED : "
						+ result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		ExtentReportManager.flushReport();

		System.out.println(
				"Test Execution Completed");
	}
}