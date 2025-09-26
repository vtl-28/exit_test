/*
 * Class name: WaitActions
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
 * This utility class provides reusable methods for implementing 
 * explicit waits in Selenium WebDriver tests.
 */

package com.ExitTest.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class to handle wait-related actions in Selenium.
 * <p>
 * Extends {@link Utility} to access the shared WebDriver instance.
 * </p>
 */
public class WaitActions extends Utility {

    /**
     * Waits explicitly until the element located by the provided locator becomes visible.
     * <p>
     * This method uses Selenium's {@link WebDriverWait} and 
     * {@link ExpectedConditions#visibilityOfElementLocated(By)} to pause 
     * execution until the element appears or the timeout expires.
     * </p>
     *
     * @param seconds Duration (in seconds) to wait before timing out.
     * @param locator {@link By} locator of the element to wait for visibility.
     */
    public static void explicitWaitUntilVisible(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
