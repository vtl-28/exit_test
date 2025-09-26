/*
 * Class name: BestSellersPage
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
 * This class represents the Best Sellers page of the AUT (Application Under Test).
 * It provides methods to interact with elements on the Best Sellers page,
 * such as retrieving the header text.
 * It extends HomePage to reuse common navigation methods.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * BestSellersPage contains locators and actions specific
 * to the Best Sellers page of the AUT.
 * This page inherits navigation functionality from HomePage.
 */
public class BestSellersPage extends HomePage {

    // ============ Locators ============
    private By sellersHeader = By.xpath("//span[@class='style__ColoredSpan-sc-1iksw1-1 bvEpHv']");

    
    /**
     * Retrieves the header text displayed on the Best Sellers page.
     *
     * @return The header text as a String
     */
    public String getHeadersText() {
        String text = getElementText(sellersHeader);
        return text;
    }
}
