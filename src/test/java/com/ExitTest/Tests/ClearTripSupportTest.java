/*
 * Class name: ClearTripSupportTest
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
 * This test class verifies that the ClearTrip Support page displays the correct 
 * error message when an invalid Trip ID is entered.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.ClearTripPage;
import com.ExitTest.Pages.ClearTripSupportPage;

/**
 * Test class for validating error message handling on the ClearTrip Support page.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It checks that entering an invalid Trip ID in the ClearTrip Support form
 * produces the correct error message.
 * </p>
 */
public class ClearTripSupportTest extends BaseTest {

    private Logger logger = LogManager.getLogger(ClearTripSupportTest.class);

    /**
     * Test case to verify that an error message is displayed when an invalid Trip ID is entered.
     * <p>
     * Steps performed:
     * 1. Navigate to the ClearTrip page.
     * 2. Close any modal pop-ups.
     * 3. Navigate to the ClearTrip Support page.
     * 4. Enter an invalid Trip ID into the support form.
     * 5. Request OTP.
     * 6. Assert that the expected error message is displayed.
     * </p>
     */
    @Test
    public void testShowErrorMessageIfTripIDIsInvalid() {
        ClearTripPage clearTripPage = homePage.goToClearTripPage();
        logger.info("Opened ClearTrip page");

        clearTripPage.closeModal();
        logger.info("Closed modal pop-up on ClearTrip page");

        // Navigate to the ClearTrip Support page
        ClearTripSupportPage clearTripSupportPage = clearTripPage.goToClearTripSupportPage();
        logger.info("Navigated to ClearTrip Support page");

        clearTripSupportPage.fillInForm("1234");
        logger.info("Entered invalid Trip ID into ClearTrip Support form");

        clearTripSupportPage.getOTP();
        logger.info("Clicked Get OTP button");

        String actualErrorMessageText = clearTripSupportPage.getErrorMessageText();

        String expectedErrorMessageText = "Please enter a valid Trip Id to get the OTP";
        logger.info("Retrieved actual and expected error messages");

        Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText,
                "Error message mismatch when entering invalid Trip ID");

        logger.info("Verified error message for invalid Trip ID successfully");
    }
}
