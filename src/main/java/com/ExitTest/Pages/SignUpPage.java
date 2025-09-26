/*
 * Class name: SignUpPage
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
 * This class represents the Sign Up page of the AUT.
 * It contains methods to fill in the mobile number field,
 * submit the form, and retrieve error messages.
 */

package com.ExitTest.Pages;

import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

import org.openqa.selenium.By;

/**
 * SignUpPage handles interactions with the Sign Up page of the application.
 * It includes methods for entering a mobile number, clicking the Continue button,
 * and fetching error messages if the sign-up input is invalid.
 */
public class SignUpPage extends HomePage {

    // ============ Locators ============
    private By mobileInputBox = By.xpath("//input[@class='r4vIwl BV+Dqf']");
    private By continueBtn = By.xpath("//span[normalize-space()='CONTINUE']");
    private By errorMessage = By.xpath("//span[contains(text(),'Please enter a valid Mobile number')]");

    // ============ Methods ============

    /**
     * Enters a mobile number into the sign-up mobile input field.
     *
     * @param number The mobile number to be entered.
     */
    public void fillInInputBox(String number) {
        set(mobileInputBox, number);
    }

    /**
     * Clicks the Continue button to attempt signing up with the provided mobile number.
     */
    public void signUp() {
        click(continueBtn);
    }

    /**
     * Retrieves the error message displayed on the sign-up page if the mobile number
     * entered is invalid.
     *
     * @return The error message as a String.
     */
    public String getErrorMessageText() {
        String text = getElementText(errorMessage);
        return text;
    }
}
