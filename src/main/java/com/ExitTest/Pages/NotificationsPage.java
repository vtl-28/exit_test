/*
 * Class name: NotificationsPage
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
 * This class represents the Notifications Page of the AUT (Application Under Test).
 * It contains locators and methods to interact with the Notifications page elements,
 * such as retrieving the header text.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * NotificationsPage contains locators and actions specific to the Notifications section
 * of the AUT. It allows you to verify elements such as the page header.
 */
public class NotificationsPage extends HomePage {

    // ============ Locators ============
    private By notificationsHeader = By.xpath("//h2[normalize-space()='Desktop Notifications']");

    // ============ Methods ============

    /**
     * Retrieves the header text displayed on the Notifications page.
     *
     * @return The header text as a String
     */
    public String getHeaderText() {
        String text = getElementText(notificationsHeader);
        return text;
    }
}
