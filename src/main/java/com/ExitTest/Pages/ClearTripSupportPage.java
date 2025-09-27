/*
 * Class name: ClearTripSupportPage
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
 * This page object models the ClearTrip Support page on the AUT.
 * It provides actions to fill in the Trip ID form, request an OTP,
 * and retrieve error messages when invalid input is entered.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;
import static com.ExitTest.Utilities.WaitActions.explicitWaitUntilVisible;

/**
 * Page Object Model (POM) class for interacting with the ClearTrip Support page.
 * <p>
 * Extends {@link ClearTripPage} to inherit shared behaviors and driver access.
 * </p>
 */
public class ClearTripSupportPage extends ClearTripPage {
    private By tripIDInput = By.xpath("//input[@placeholder='Enter Trip ID']");

    private By getOTPBtn = By.xpath("//button[@type='submit']");

    private By errorMessage = By.xpath("//p[@class='errMsg']");

    /**
     * Fills in the Trip ID input field with the provided Trip ID.
     * <p>
     * Clicks the field first to focus it and then sends the input.
     * </p>
     *
     * @param tripID The Trip ID to enter into the input field.
     */
    public void fillInForm(String tripID) {
        explicitWaitUntilVisible(5, tripIDInput);
        click(tripIDInput);
        set(tripIDInput, tripID);
    }

    /**
     * Clicks the 'Get OTP' button to request a one-time password.
     */
    public void getOTP() {
    	explicitWaitUntilVisible(5, getOTPBtn);
        click(getOTPBtn);
    }

    /**
     * Retrieves the error message text displayed after submitting an invalid Trip ID.
     *
     * @return The error message text as a String.
     */
    public String getErrorMessageText() {
    	 explicitWaitUntilVisible(5, errorMessage);
        String text = getElementText(errorMessage);
        return text;
    }
}
