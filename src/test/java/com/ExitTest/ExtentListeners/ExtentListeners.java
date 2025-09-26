/*
 * Class name: ExtentListeners
 *
 * Version info: v1
 *
 * Author info: Vuisile Lehola
 *
 * Creation date: 17 September 2025
 *
 * Last updated By: Vuisile Lehola
 *
 * Last updated Date: 29 September 2025
 *
 * Description:
 * This class is a TestNG listener that integrates ExtentReports with the test suite.
 * It generates detailed HTML reports for passed, failed, and skipped tests,
 * and also captures screenshots of failed tests for better debugging.
 */

package com.ExitTest.ExtentListeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * TestNG listener to hook into test lifecycle events and generate
 * ExtentReports HTML reports. Captures screenshots on test failure
 * and creates a summary report after the suite finishes.
 */
public class ExtentListeners extends TestListenerAdapter {

    private Logger logger = LogManager.getLogger(ExtentListeners.class);

    /**
     * Triggered when each test starts.
     *
     * @param tr The {@link ITestResult} instance containing test details.
     */
    @Override
    public void onTestStart(ITestResult tr) {
        String testName = tr.getMethod().getMethodName();
        String className = tr.getTestClass().getName();
        String fullTestName = className + "." + testName;

        logger.info("ExtentReports: Test started - " + fullTestName);
    }

    /**
     * Triggered when a test passes successfully.
     *
     * @param tr The {@link ITestResult} instance containing test details.
     */
    @Override
    public void onTestSuccess(ITestResult tr) {
        String testName = tr.getMethod().getMethodName();
        logger.info("ExtentReports: Test passed - " + testName);
    }

    /**
     * Triggered when a test fails. Generates a detailed report and screenshot.
     *
     * @param tr The {@link ITestResult} instance containing test details.
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        String testName = tr.getMethod().getMethodName();
        String className = tr.getTestClass().getName();
        String fullTestName = className + "." + testName;

        logger.info("ExtentReports: Test failed - " + fullTestName);

        createFailedTestReport(tr, testName, fullTestName);
    }

    /**
     * Creates a dedicated Extent report for the failed test.
     *
     * @param tr The {@link ITestResult} instance.
     * @param testName Name of the test method.
     * @param fullTestName Fully qualified test name.
     */
    private void createFailedTestReport(ITestResult tr, String testName, String fullTestName) {
        try {
            String reportDir = System.getProperty("user.dir") + "/target/extent-reports/";
            String reportPath = reportDir + testName + "__" + tr.getThrowable().getClass().getSimpleName() + ".html";

            ExtentReports extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Failed Test Report - " + testName);
            spark.config().setReportName("Failed Test Report: " + testName);
            spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

            extent.attachReporter(spark);

            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Test Class", tr.getTestClass().getName());
            extent.setSystemInfo("Test Method", testName);
            extent.setSystemInfo("Failure Time", new java.util.Date().toString());

            ExtentTest test = extent.createTest(fullTestName);

            if (tr.getThrowable() != null) {
                test.fail("Test failed with: " + tr.getThrowable().getClass().getSimpleName());
            } else {
                test.fail("Test execution failed");
            }

            addScreenshotToReport(test, tr, testName, reportDir);

            extent.flush();

            logger.info("ExtentReports: Failed test report created at " + reportPath);

        } catch (Exception e) {
            logger.error("Failed to create failed test report for " + testName, e);
        }
    }

    /**
     * Captures a screenshot of the browser at the point of failure
     * and adds it to the Extent report.
     *
     * @param test The {@link ExtentTest} instance for the failed test.
     * @param tr The {@link ITestResult} instance.
     * @param testName Name of the failed test.
     * @param reportDir Directory where screenshots will be saved.
     */
    private void addScreenshotToReport(ExtentTest test, ITestResult tr, String testName, String reportDir) {
        try {
            WebDriver driver = com.ExitTest.Base.BaseTest.driver;

            if (driver != null) {
                String screenshotName = testName + "__" + tr.getThrowable().getClass().getSimpleName() + ".png";
                String screenshotPath = reportDir + screenshotName;

                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                File destFile = new File(screenshotPath);

                destFile.getParentFile().mkdirs();

                FileUtils.copyFile(sourceFile, destFile);

                test.addScreenCaptureFromPath(screenshotName)
                        .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());

                logger.info("Screenshot captured for failed test: " + screenshotName);
            } else {
                logger.warn("WebDriver is null, cannot capture screenshot for test: " + testName);
                test.fail("Screenshot could not be captured - WebDriver is null");
            }

        } catch (Exception e) {
            logger.error("Failed to capture screenshot for test: " + testName, e);
            test.fail("Failed to capture screenshot: " + e.getMessage());
        }
    }

    /**
     * Triggered when a test is skipped.
     *
     * @param result The {@link ITestResult} instance.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        logger.info("ExtentReports: Test skipped - " + testName);
    }

    /**
     * Triggered after all tests have finished executing. Creates a summary report.
     *
     * @param context The {@link ITestContext} containing suite details.
     */
    @Override
    public void onFinish(ITestContext context) {
        logger.info("ExtentReports: Test Suite finished");
        createSummaryReport(context);
    }

    /**
     * Creates a summary Extent report showing all tests, their status, and system info.
     *
     * @param context The {@link ITestContext} containing suite and test details.
     */
    private void createSummaryReport(ITestContext context) {
        try {
            String reportDir = System.getProperty("user.dir") + "/target/extent-reports/";
            String summaryReportPath = reportDir + "TestSuite_Summary_Report.html";

            ExtentReports summaryExtent = new ExtentReports();
            ExtentSparkReporter summaryReporter = new ExtentSparkReporter(summaryReportPath);

            summaryReporter.config().setTheme(Theme.STANDARD);
            summaryReporter.config().setDocumentTitle("Test Suite Summary Report");
            summaryReporter.config().setReportName("Complete Test Suite Results");
            summaryReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

            summaryExtent.attachReporter(summaryReporter);

            summaryExtent.setSystemInfo("OS", System.getProperty("os.name"));
            summaryExtent.setSystemInfo("Java Version", System.getProperty("java.version"));
            summaryExtent.setSystemInfo("User", System.getProperty("user.name"));
            summaryExtent.setSystemInfo("Browser", "Chrome");
            summaryExtent.setSystemInfo("Suite Name", context.getSuite().getName());
            summaryExtent.setSystemInfo("Total Tests", String.valueOf(context.getAllTestMethods().length));
            summaryExtent.setSystemInfo("Passed Tests", String.valueOf(context.getPassedTests().size()));
            summaryExtent.setSystemInfo("Failed Tests", String.valueOf(context.getFailedTests().size()));
            summaryExtent.setSystemInfo("Skipped Tests", String.valueOf(context.getSkippedTests().size()));

            for (ITestResult result : context.getPassedTests().getAllResults()) {
                ExtentTest summaryTest = summaryExtent.createTest(result.getMethod().getMethodName());
                summaryTest.pass("Test passed successfully");
            }

            for (ITestResult result : context.getFailedTests().getAllResults()) {
                ExtentTest summaryTest = summaryExtent.createTest(result.getMethod().getMethodName());
                summaryTest.fail("Test failed: " + result.getThrowable().getMessage());
            }

            for (ITestResult result : context.getSkippedTests().getAllResults()) {
                ExtentTest summaryTest = summaryExtent.createTest(result.getMethod().getMethodName());
                summaryTest.skip("Test skipped: "
                        + (result.getThrowable() != null ? result.getThrowable().getMessage() : "No reason provided"));
            }

            summaryExtent.flush();
            logger.info("Summary report created at: " + summaryReportPath);

        } catch (Exception e) {
            logger.error("Failed to create summary report", e);
        }
    }
}
