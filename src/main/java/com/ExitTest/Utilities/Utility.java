/*
 * Class name: Utility
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
 * This utility class provides a central place to hold the shared WebDriver 
 * instance for other utility classes that may not directly extend BasePage.
 * It copies the driver from BasePage so it can be used anywhere in the project.
 */

package com.ExitTest.Utilities;

import org.openqa.selenium.WebDriver;

import com.ExitTest.Base.BasePage;

/**
 * Utility class to store and access the shared {@link WebDriver} instance.
 * <p>
 * This class acts as a bridge for utility classes that need to use the driver 
 * without extending {@link BasePage}.
 * </p>
 */
public class Utility {

    /** 
     * Static WebDriver instance shared across utilities. 
     */
    public static WebDriver driver;

    /**
     * Initializes the static driver of this utility class with the driver 
     * instance from {@link BasePage}.
     * <p>
     * This method should be called after the driver in {@link BasePage} 
     * has been initialized (usually in the @BeforeClass method of BaseTest).
     * </p>
     */
    public static void setUtility() {
        driver = BasePage.driver;
    }
}
