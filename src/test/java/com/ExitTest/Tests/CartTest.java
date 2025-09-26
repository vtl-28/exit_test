/*
 * Class name: CartTest
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
 * This test class verifies that the Cart page prompts users to log in 
 * to view items previously added to their cart.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.CartPage;

/**
 * Test class for validating the login prompt on the Cart page.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It ensures that the Cart page displays the expected login message
 * for users who are not signed in.
 * </p>
 */
public class CartTest extends BaseTest {

    private Logger logger = LogManager.getLogger(CartTest.class);

    /**
     * Test case to verify that the Cart page prompts the user to log in
     * when accessing it without authentication.
     * <p>
     * Steps performed:
     * 1. Navigate to the Cart page.
     * 2. Retrieve the login prompt text displayed on the page.
     * 3. Assert that the login prompt matches the expected message.
     * </p>
     */
    @Test
    public void testCartPage() {
        CartPage cartPage = homePage.goToCartPage();
        logger.info("Opened Cart page");

        String actualText = cartPage.getLoginCartText();
        String expectedText = "Login to see the items you added previously";
        logger.info("Retrieved actual and expected login prompt text");

        Assert.assertEquals(actualText, expectedText,
                "Login prompt message on Cart page did not match expected value");

        logger.info("Verified login prompt text on Cart page successfully");
    }
}
