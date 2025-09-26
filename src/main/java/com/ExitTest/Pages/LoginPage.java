/*
 * Class name: LoginPage
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
 * This class represents the Login Page of the AUT (Application Under Test).
 * It contains locators and methods to interact with login functionality,
 * such as filling in the login input box, requesting an OTP, and
 * retrieving error messages. This class extends HomePage to reuse
 * common navigation and WebDriver interactions.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * LoginPage contains locators and actions specific
 * to the Login page of the AUT.
 * It provides methods for entering login credentials,
 * submitting login requests, and retrieving error messages.
 */
public class LoginPage extends HomePage {

    // ============ Locators ============
    private By inputBox = By.xpath("//input[@class='r4vIwl BV+Dqf']");
    private By requestOTPBtn = By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']");
    private By errorMessage = By.xpath("//span[contains(text(),'Please enter valid Email ID/Mobile number')]");

    // ============ Methods ============

    /**
     * Fills the login input box with the provided email or mobile number.
     *
     * @param number The email ID or mobile number to input
     */
    public void fillInputBox(String number) {
        set(inputBox, number);
    }

    /**
     * Clicks on the Request OTP button to attempt login.
     */
    public void login() {
        click(requestOTPBtn);
    }

    /**
     * Retrieves the error message text displayed on the Login page.
     *
     * @return The error message text as a String
     */
    public String getErrorMessageText() {
        String text = getElementText(errorMessage);
        return text;
    }
}
