/*
 * Class name: OffersPage
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
 * This class represents the Offers Page of the AUT (Application Under Test).
 * It contains locators and methods to interact with the Offers page elements,
 * such as retrieving the page header text.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * OffersPage contains locators and actions specific to the Offers section
 * of the AUT. It allows you to verify elements such as the page header.
 */
public class OffersPage extends HomePage {

    // ============ Locators ============
    private By headerText = By.xpath("//div[@class='lF7HP0']");

    // ============ Methods ============

    
    /**
     * Retrieves the header text displayed on the Offers page.
     *
     * @return The header text as a String
     */
    public String getHeaderText() {
        String text = getElementText(headerText);
        return text;
    }
}
