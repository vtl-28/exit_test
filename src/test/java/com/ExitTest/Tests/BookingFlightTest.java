/*
 * Class name: BookingFlightTest
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
 * This test class verifies that mandatory fields on the flight booking page 
 * are validated properly and display the correct error messages when left empty.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.FlightBookingsPage;

/**
 * Test class for validating mandatory field checks on the flight booking page.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It ensures that leaving the departure and arrival city fields empty 
 * triggers the correct error messages.
 * </p>
 */
public class BookingFlightTest extends BaseTest {

    private Logger logger = LogManager.getLogger(BookingFlightTest.class);

    
    /**
     * Test case to verify that mandatory fields (departure city and arrival city)
     * on the flight booking form display appropriate error messages when left blank.
     * <p>
     * Steps performed:
     * 1. Navigate to the flight booking page.
     * 2. Clear the form fields.
     * 3. Attempt to search for flights without filling in the fields.
     * 4. Assert that correct error messages appear for both fields.
     * </p>
     */
    @Test
    public void testThatMandoryFieldsAreFilledIn() {
        FlightBookingsPage flightBookingsPage = homePage.goToFlightBookingsPage();
        logger.info("Opened flight booking page");

        flightBookingsPage.clearBookingFlightForm();
        logger.info("Cleared flight booking form");

        flightBookingsPage.searchFlights();
        logger.info("Clicked 'Search' button without entering mandatory fields");

        String actualDepartErrorMessage = flightBookingsPage.getDepartCityErrorMessage();
        String actualArrivalErrorMessage = flightBookingsPage.getArrivalCityErrorMessage();

        Assert.assertEquals(actualDepartErrorMessage, "origin cannot be empty",
                "Departure city error message mismatch");
        Assert.assertEquals(actualArrivalErrorMessage, "destination cannot be empty",
                "Arrival city error message mismatch");

        logger.info("Verified error messages for mandatory flight booking fields");
    }
}
