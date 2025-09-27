/*
 * Class name: ClearTripPage
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
 * This page object models the ClearTrip page on the AUT. It provides actions
 * to close modal pop-ups, search for flights, retrieve error messages,
 * and navigate to the ClearTrip Support page.
 */

package com.ExitTest.Pages;

import static com.ExitTest.Utilities.JavaScriptActions.scrollToElementJSWithOffset;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;
import static com.ExitTest.Utilities.WaitActions.explicitWaitUntilVisible;
import org.openqa.selenium.By;

/**
 * Page Object Model (POM) class for interacting with the ClearTrip page.
 * <p>
 * Extends {@link HomePage} to inherit shared WebDriver actions.
 * </p>
 */
public class ClearTripPage extends HomePage {
    private By searchFlightsBtn = By.xpath("//h4[@class='sc-gEvEer AHmHT']");

    private By errorMessage = By.xpath("//span[@class='fw-500 fs-2 ml-4']");

    private By closeModalBtn = By.xpath("//div[@class='pb-1 px-1 flex flex-middle nmx-1']//*[name()='svg']//*[name()='path' and contains(@d,'M18 6L12 1')]");

    private By supportNavItem = By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div[2]/div[1]/div[4]/div");
    
    private By closeFooterModalBtn = By.xpath("//div[@class='closeit']");
    
    private By tripIDInput = By.xpath("//input[@placeholder='Enter Trip ID']");

    /**
     * Closes the modal popup displayed on the ClearTrip page.
     * <p>
     * Uses the shared {@link #click(By)} method from BasePage.
     * </p>
     */
    public void closeModal() {
        click(closeModalBtn);
    }
    
    public void closeFooterModal() {
    	click(closeFooterModalBtn);
    }

    /**
     * Scrolls to the 'Search Flights' button and clicks it to initiate a flight search.
     * <p>
     * Uses JavaScript scrolling to ensure the button is visible on the viewport before clicking.
     * </p>
     */
    public void searchFlights() {
        scrollToElementJSWithOffset(searchFlightsBtn);
        click(searchFlightsBtn);
    }

    /**
     * Retrieves the error message displayed when flight search fields are incomplete.
     *
     * @return The error message text as a String.
     */
    public String getErrorMessageText() {
        String text = getElementText(errorMessage);
        return text;
    }

    /**
     * Navigates to the ClearTrip Support page by clicking the support navigation item.
     *
     * @return A new instance of {@link ClearTripSupportPage} representing the Support page.
     */
    public ClearTripSupportPage goToClearTripSupportPage() {
        click(supportNavItem);
        explicitWaitUntilVisible(5, tripIDInput);
        return new ClearTripSupportPage();
    }
}
