/*
 * Class name: AdvertisePage
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
 * This class represents the Advertise page of the AUT (Application Under Test).
 * It provides methods to interact with elements on the Advertise page.
 * Extends HomePage to reuse common navigation methods.
 */

package com.ExitTest.Pages;

import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

import org.openqa.selenium.By;

/**
 * AdvertisePage contains locators and actions
 * specific to the Advertise page of the AUT.
 * This page inherits common navigation functionality
 * from HomePage.
 */
public class AdvertisePage extends HomePage {

    // ============ Locators ============
    private By loginText = By.xpath("//p[@class='styles__SubHeading-sc-18s7njp-8 jMSWrM']");

    
    /**
     * Retrieves the login text displayed on the Advertise page.
     *
     * @return The login text as a String
     */
    public String getLoginText() {
        String text = getElementText(loginText);
        return text;
    }
}
