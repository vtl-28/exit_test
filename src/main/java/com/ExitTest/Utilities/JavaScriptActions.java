/*
 * Class name: JavaScriptActions
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
 * This utility class provides helper methods to perform actions using JavaScript
 * on web elements such as scrolling into view with or without offset.
 */

package com.ExitTest.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Utility class containing JavaScript-based actions for scrolling and interacting
 * with elements on a webpage.
 * <p>
 * Extends {@link Utility} to access the shared WebDriver instance.
 * </p>
 */
public class JavaScriptActions extends Utility {

    /**
     * Scrolls the page until the specified element is visible in the viewport.
     * <p>
     * This method uses the JavaScript function <code>scrollIntoView()</code>
     * to bring the element into view without any offset.
     * </p>
     *
     * @param locator {@link By} locator of the element to scroll into view.
     */
    public static void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);

        String jsScript = "arguments[0].scrollIntoView();";

        ((JavascriptExecutor) driver).executeScript(jsScript, element);
    }

    /**
     * Scrolls the page to bring the specified element into view with an offset.
     * <p>
     * This is useful when elements are hidden under sticky headers or 
     * fixed navigation bars. It scrolls slightly above the element.
     * </p>
     *
     * @param locator {@link By} locator of the element to scroll into view.
     */
    public static void scrollToElementJSWithOffset(By locator) {
        WebElement element = driver.findElement(locator);
        
        String jsScript =  "const yOffset = -200;" +
                "const y = arguments[0].getBoundingClientRect().top + window.pageYOffset + yOffset;" +
                "window.scrollTo({top: y, behavior: 'smooth'});";

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        
        executor.executeScript(jsScript, element);
    }
}
