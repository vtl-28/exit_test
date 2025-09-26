/*
 * Class name: BasePage
 *
 * Version info: v1
 *
 * Author: Vuisile Lehola
 *
 * Creation date: 17 September 2025
 *
 * Last updated By: Vuisile Lehola
 *
 * Last updated Date: 29 September 2025
 *
 * Description: 
 * This class serves as the base class for all Page Object Model (POM) pages. 
 * It centralizes WebDriver initialization and provides commonly used actions 
 * such as finding, clicking, and setting values on elements.
 */

package com.ExitTest.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage is a reusable base class for all page objects.
 * It manages the WebDriver instance and provides helper methods
 * to interact with web elements.
 */
public class BasePage {

    /** Shared WebDriver instance across page objects */
    public static WebDriver driver;

    /**
     * Sets the WebDriver instance for this page and initializes
     * all @FindBy elements with PageFactory.
     *
     * @param driver The WebDriver instance to be used.
     */
    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
        // Initialize WebElements annotated with @FindBy
        PageFactory.initElements(driver, this);
    }

    /**
     * Finds a web element using the given locator.
     *
     * @param locator The By locator strategy (By.id, By.xpath, etc.)
     * @return The WebElement found on the page.
     */
    protected static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Clears and enters text into a web element.
     *
     * @param locator The By locator strategy.
     * @param text The text to send to the element.
     */
    protected void set(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks on a web element.
     *
     * @param locator The By locator strategy.
     */
    protected void click(By locator) {
        find(locator).click();
    }
}
