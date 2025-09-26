/*
 * Class name: MobilesTabletsPage
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
 * This class represents the Mobiles & Tablets Page of the AUT (Application Under Test).
 * It contains locators and methods to interact with elements on the Mobiles & Tablets page,
 * such as retrieving the page header text and navigating to the Offers page.
 */

package com.ExitTest.Pages;

import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

import org.openqa.selenium.By;

/**
 * MobilesTabletsPage contains locators and actions specific
 * to the Mobiles & Tablets section of the AUT.
 * It provides methods to read the page header and navigate to the Offers page.
 */
public class MobilesTabletsPage extends HomePage {

    // ============ Locators ============
    private By mobilePhonesHeader = By.xpath("//h1[@class='_0FYq1K']");
    private By offerZoneNavItem = By.xpath("//a[normalize-space()='Offer Zone']");

    
    // ============ Methods ============

    /**
     * Retrieves the header text of the Mobiles & Tablets page.
     *
     * @return The header text as a String
     */
    public String mobilePhonesHeaderText() {
        String text = getElementText(mobilePhonesHeader);
        return text;
    }

    /**
     * Navigates to the Offers page from the Mobiles & Tablets section.
     *
     * @return A new instance of OffersPage representing the Offers page
     */
    public OffersPage goToOffersPage() {
        click(offerZoneNavItem);
        return new OffersPage();
    }
}
