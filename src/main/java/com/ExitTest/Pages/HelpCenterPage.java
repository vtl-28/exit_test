/*
 * Class name: HelpCenterPage
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
 * This class represents the Help Center page of the AUT (Application Under Test).
 * It provides methods to interact with elements on the Help Center page, such as
 * retrieving the page header and navigating to Notifications and Advertise pages.
 * It extends HomePage to reuse common navigation methods.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * HelpCenterPage contains locators and actions specific
 * to the Help Center page of the AUT.
 * This page inherits navigation functionality from HomePage.
 */
public class HelpCenterPage extends HomePage {

    // ============ Locators ============
    private By navItemHeader = By.xpath("//div[@class='TH4Ru2 zCXJ05']//span[contains(text(),'Help Center')]");
    private By moreNavItem = By.xpath("//div[@class='RbF1Du']//div[@class='UL9nZx']");
    private By notificationsNavItem = By.xpath("//div[normalize-space()='Notification Preferences']");
    private By advertiseNavItem = By.xpath("//div[contains(text(),'Advertise')]");


    Actions act = new Actions(driver);

    /**
     * Retrieves the Help Center navigation header text.
     *
     * @return The Help Center header text as a String
     */
    public String getNavItemHeaderText() {
        String text = getElementText(navItemHeader);
        return text;
    }

    /**
     * Navigates to the Notifications page by hovering over the More menu
     * and clicking the Notifications item.
     *
     * @return NotificationsPage page object
     */
    public NotificationsPage goToNotificationsPage() {
        act.moveToElement(find(moreNavItem)).perform();
        click(notificationsNavItem);
        return new NotificationsPage();
    }

    /**
     * Navigates to the Advertise page by hovering over the More menu
     * and clicking the Advertise item.
     *
     * @return AdvertisePage page object
     */
    public AdvertisePage goToAdvertisePage() {
        act.moveToElement(find(moreNavItem)).perform();
        click(advertiseNavItem);
        return new AdvertisePage();
    }
}
