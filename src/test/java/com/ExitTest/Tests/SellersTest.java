/*
 * Class name: SellersTest
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
 * This test validates the navigation to the Best Sellers page and ensures
 * the correct header text is displayed, confirming the user has landed on
 * the right page.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.BestSellersPage;

/**
 * Test class to verify that the Best Sellers page displays the expected header text.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and initialized HomePage object.
 * </p>
 */
public class SellersTest extends BaseTest {

    private Logger logger = LogManager.getLogger(SellersTest.class);

    /**
     * Test case to validate that the user is able to navigate to the Best Sellers page.
     * <p>
     * Steps performed:
     * 1. Navigate to the Best Sellers page from the home page.
     * 2. Retrieve the header text displayed on the Best Sellers page.
     * 3. Compare the retrieved text with the expected text.
     * </p>
     */
    @Test
    public void testSellersPage() {
        BestSellersPage sellersPage = homePage.goToBestSellersPage();
        logger.info("Navigated to the Best Sellers page");

        String actualText = sellersPage.getHeadersText();

        String expectedText = "Sell Online with Flipkart";
        logger.info("Retrieved actual and expected header text");

        Assert.assertEquals(actualText, expectedText,
                "The Best Sellers page header text does not match the expected text");
        logger.info("Verified Best Sellers page successfully");
    }
}
