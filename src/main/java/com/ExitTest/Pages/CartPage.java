/*
 * Class name: CartPage
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
 * This class represents the Cart page of the AUT (Application Under Test).
 * It provides methods to interact with elements on the Cart page,
 * such as retrieving the login/cart text.
 * It extends HomePage to reuse common navigation methods.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * CartPage contains locators and actions specific
 * to the Cart page of the AUT.
 * This page inherits navigation functionality from HomePage.
 */
public class CartPage extends HomePage {

    // ============ Locators ============/
    private By loginCartText = By.xpath("//div[@class='orqM3-']");

    
    /**
     * Retrieves the login/cart text displayed on the Cart page.
     *
     * @return The login/cart text as a String
     */
    public String getLoginCartText() {
        String text = getElementText(loginCartText);
        return text;
    }
}
