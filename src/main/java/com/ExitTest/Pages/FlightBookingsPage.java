/*
 * Class name: FlightBookingsPage
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
 * This class represents the Flight Bookings page of the AUT (Application Under Test).
 * It provides methods to interact with elements on the Flight Bookings page, such as
 * entering departure and arrival cities, submitting the search, and retrieving error messages.
 * It extends HomePage to reuse common navigation methods.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * FlightBookingsPage contains locators and actions specific
 * to the Flight Bookings page of the AUT.
 * This page inherits navigation functionality from HomePage.
 */
public class FlightBookingsPage extends HomePage {

    // ============ Locators ============
    private By departCityInput = By.xpath("//input[@name='0-departcity']");
    private By arrivalCityInput = By.xpath("//input[@name='0-arrivalcity']");
    private By searchFlightsBtn = By.xpath("//span[normalize-space()='SEARCH']");
    private By departCityErrorMessage = By.xpath("//div[normalize-space()='origin cannot be empty']");
    private By arrivalCityErrorMessage = By.xpath("//div[normalize-space()='destination cannot be empty']");

    /**
     * Clears the departure and arrival city fields in the flight booking form.
     */
    public void clearBookingFlightForm() {
        find(departCityInput).clear();
        find(arrivalCityInput).clear();
    }

    /**
     * Clicks the Search Flights button to submit the flight booking form.
     */
    public void searchFlights() {
        click(searchFlightsBtn);
    }

    /**
     * Retrieves the error message displayed when the departure city field is empty.
     *
     * @return The departure city error message as a String
     */
    public String getDepartCityErrorMessage() {
        String text = getElementText(departCityErrorMessage);
        return text;
    }

    /**
     * Retrieves the error message displayed when the arrival city field is empty.
     *
     * @return The arrival city error message as a String
     */
    public String getArrivalCityErrorMessage() {
        String text = getElementText(arrivalCityErrorMessage);
        return text;
    }
}
