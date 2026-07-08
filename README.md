# Selenium Automation Framework

A robust Selenium Test Automation Framework built using Java, TestNG, Maven, and Page Object Model (POM) design pattern. The framework supports cross-browser execution, data-driven testing, reporting, and CI/CD integration using Jenkins.

## Tech Stack

* Java 21
* Selenium WebDriver 4
* TestNG
* Maven
* Apache POI (Excel Data Handling)
* Extent Reports
* Allure Reports
* Log4j
* Jenkins
* Git & GitHub
* WebDriverManager

## Framework Features

* Page Object Model (POM)
* Data-Driven Testing using Excel
* Cross-Browser Testing
* ThreadLocal WebDriver Support
* Retry Analyzer for Failed Tests
* Screenshot Capture on Failure
* Explicit Wait Implementation
* Extent HTML Reporting
* Allure Reporting Integration
* Jenkins Freestyle Job Integration
* Jenkins Pipeline Integration
* Maven Build Management
* GitHub Source Control Integration
* Configurable Test Execution via testng.xml

## Project Structure

src/main/java

* Pages
* Factory
* Utilities
* Base
* Listeners
* Reports

src/main/resources

* log4j
* config files

src/test/java

* Test Cases

src/test/resources

* testng.xml
* Test Data

## Reports

### Extent Report

Reports/AutomationReport.html

### Allure Report

allure-results/

## Execute Tests

### Run Through Maven

```bash
mvn clean test
```

### Run Through TestNG

Execute:

```text
src/test/resources/testng.xml
```

## CI/CD Integration

* Jenkins Freestyle Project
* Jenkins Pipeline Project
* Email Notifications
* HTML Report Publishing
* Allure Dashboard Reporting

## Author

Kusma Verma
