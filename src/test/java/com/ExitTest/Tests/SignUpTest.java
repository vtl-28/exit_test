/*
 * Class name: SignUpTest
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
 * This test validates that when an invalid mobile number is entered on the
 * sign-up page, the appropriate error message is displayed to the user.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.SignUpPage;

/**
 * Test class to validate the sign-up functionality using an invalid mobile number.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and initialized HomePage object.
 * </p>
 */
public class SignUpTest extends BaseTest {

    /** Logger instance to track the execution flow of this test class. */
    private Logger logger = LogManager.getLogger(SignUpTest.class);

    /**
     * Test case to verify that entering an invalid mobile number during sign-up
     * displays the correct error message.
     * <p>
     * Steps performed:
     * 1. Navigate to the sign-up page.
     * 2. Enter an invalid mobile number.
     * 3. Attempt to sign up.
     * 4. Validate that the displayed error message matches the expected text.
     * </p>
     *
     * @param mobileNumber the mobile number parameter, passed from testng.xml or uses default value
     */
    @Test
    @Parameters("mobileNumber")
    public void testSignUpWithInvalidMobileNumber(@Optional("1234567890") String mobileNumber) {
        SignUpPage signUp = homePage.goToSignUpPage();
        logger.info("Navigated to the Sign Up page");

        signUp.fillInInputBox(mobileNumber);
        logger.info("Entered invalid mobile number: {}", mobileNumber);

        signUp.signUp();
        logger.info("Clicked Sign Up button");

        String actualErrorMessage = signUp.getErrorMessageText();
        String expectedErrorMessage = "Please enter a valid Mobile number";
        logger.info("Retrieved actual and expected error message");

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message displayed on sign-up page does not match the expected text");
        logger.info("Verified sign-up error message successfully");
    }
}
