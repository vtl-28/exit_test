/*
 * Class name: ClearTripTest
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
 * This test class verifies that the ClearTrip page displays the correct 
 * error message when attempting to search for flights without 
 * filling in the required form fields.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.ClearTripPage;

/**
 * Test class for validating mandatory field checks on the ClearTrip page.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It ensures that attempting to search for flights without entering
 * departure and arrival airports/cities shows the correct error message.
 * </p>
 */
public class ClearTripTest extends BaseTest {

    private Logger logger = LogManager.getLogger(ClearTripTest.class);

    /**
     * Test case to verify that an error message is displayed when required fields
     * are not filled in before searching flights on the ClearTrip page.
     * <p>
     * Steps performed:
     * 1. Navigate to the ClearTrip page.
     * 2. Close any modal pop-up window.
     * 3. Attempt to search for flights without filling the form.
     * 4. Validate the displayed error message matches the expected text.
     * </p>
     */
    @Test
    public void testFillInFormBeforeSearchingFlights() {
        ClearTripPage clearTripPage = homePage.goToClearTripPage();
        logger.info("Opened ClearTrip page");

        clearTripPage.closeModal();
        logger.info("Closed modal that appears on ClearTrip page");

        clearTripPage.searchFlights();
        logger.info("Clicked search flights button without entering data");

        String actualErrorMessageText = clearTripPage.getErrorMessageText();

        String expectedErrorMessageText = "Enter departure and arrival airports / cities";
        logger.info("Retrieved actual and expected error messages");

        Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText,
                "Error message mismatch when required fields are empty");

        logger.info("Verified error message for empty fields on ClearTrip page");
    }
}
