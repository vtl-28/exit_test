/*
 * Class name: LoginTest
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
 * This test class verifies the login functionality of the AUT. 
 * It checks that an invalid mobile number produces the correct error message.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.LoginPage;

/**
 * Test class to validate login functionality with invalid credentials.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and 
 * the initialized HomePage object.
 * </p>
 */
public class LoginTest extends BaseTest {

    private Logger logger = LogManager.getLogger(LoginTest.class);

    /**
     * Test case to verify that logging in with an invalid mobile number 
     * displays the correct error message.
     * <p>
     * Steps performed:
     * 1. Navigate to the Login page.
     * 2. Enter an invalid mobile number (provided via TestNG parameter).
     * 3. Click the login button.
     * 4. Assert that the displayed error message matches the expected value.
     * </p>
     *
     * @param mobileNumber The invalid mobile number to test with (injected from testng.xml).
     */
    @Test
    @Parameters("mobileNumber")
    public void testLoginWithInvalidNumber(@Optional("1234567890") String mobileNumber) {
        LoginPage loginPage = homePage.goToLoginPage();
        logger.info("Opened login page");
        
        loginPage.fillInputBox(mobileNumber);
        logger.info("Entered invalid mobile number: {}", mobileNumber);

        loginPage.login();
        logger.info("Clicked login button");

        String actualErrorText = loginPage.getErrorMessageText();

        String expectedErrorText = "Please enter valid Email ID/Mobile number";
        logger.info("Retrieved actual and expected error messages");

        Assert.assertEquals(actualErrorText, expectedErrorText,
                "Error message displayed for invalid mobile number did not match expected value");

        logger.info("Verified invalid login error message successfully");
    }
}
