/*
 * Class name: BaseTest
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
 * This base test class sets up and tears down the Selenium WebDriver instance 
 * for all test classes. It initializes browser drivers, navigates to the AUT, 
 * and prepares page objects.
 */

package com.ExitTest.Base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ExitTest.Pages.HomePage;
import com.ExitTest.Utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base test class used as the parent for all test classes.
 * <p>
 * This class handles WebDriver setup, initialization of page objects,
 * and teardown after test execution.
 * </p>
 */
public class BaseTest {

    public static WebDriver driver;
    public Logger logger = LogManager.getLogger(BaseTest.class);
    
    protected BasePage basePage;
    protected HomePage homePage;

    /**
     * Sets up the WebDriver and initializes page objects before running the test class.
     * <p>
     * This method reads browser type and AUT URL from TestNG parameters. 
     * If none are provided, it defaults to Chrome and Flipkart URL.
     * </p>
     *
     * @param nameOfBrowser Browser type (chrome/firefox/edge) specified in testng.xml.
     * @param AUT Application Under Test (URL) specified in testng.xml.
     */
    @BeforeClass
    @Parameters({ "browser", "AUT" })
    public void setUp(@Optional("chrome") String nameOfBrowser, 
                      @Optional("https://www.flipkart.com/") String AUT) {
        logger.info("Starting test setup from the BaseTest class");


        switch (nameOfBrowser.toLowerCase()) {
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
            default:
                driver = WebDriverManager.chromedriver().create();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        driver.get(AUT);

        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
        homePage.setDriver(driver);

        Utility.setUtility();
    }

    /**
     * Quits the WebDriver instance and cleans up resources after all tests in the class are complete.
     */
    @AfterClass
    public void tearDown() {
        logger.info("Ending test from the BaseTest class");
        driver.quit();
    }
}
