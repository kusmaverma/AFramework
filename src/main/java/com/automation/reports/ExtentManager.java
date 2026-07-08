package com.automation.reports;
import com.automation.util.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("Reports/AutomationReport.html");

            sparkReporter.config().setReportName("Automation Framework Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            ConfigReader config = new ConfigReader();
            extent.setSystemInfo("Tester", "Sanjay Verma");
            extent.setSystemInfo("Environment", "QA");
            

            extent.setSystemInfo(
            		"Browser",
            		config.getBrowser());
        }

        return extent;
    }
}