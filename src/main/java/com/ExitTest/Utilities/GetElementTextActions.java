/*
 * Class name: GetElementTextActions
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
 * This utility class provides a reusable method to get the text of a
 * WebElement on a page. It extends HomePage so it can use the find() method
 * for locating elements. This helps keep code clean and consistent across tests.
 */

package com.ExitTest.Utilities;

import org.openqa.selenium.By;

import com.ExitTest.Pages.HomePage;

/**
 * Utility class that provides methods to retrieve text from WebElements.
 * <p>
 * By extending {@link HomePage}, this class gains access to the shared
 * WebDriver instance and the `find()` method.
 * </p>
 */
public class GetElementTextActions extends HomePage {

    /**
     * Retrieves the visible text of a WebElement found using the specified locator.
     * It also removes unnecessary double quotes and trims surrounding whitespace.
     *
     * @param locator The Selenium {@link By} locator of the element to retrieve text from.
     * @return A cleaned-up String containing the element's text.
     */
    public static String getElementText(By locator) {
        return find(locator).getText().replace("\"", "").trim();
    }
}
