/*
 * Class name: FAQTest
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
 * This test class verifies that the Help Center (FAQ) page loads successfully 
 * and displays the correct header text.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.HelpCenterPage;

/**
 * Test class for validating the Help Center (FAQ) page header.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It ensures that navigating to the Help Center page displays 
 * the expected header text ("Help Center").
 * </p>
 */
public class FAQTest extends BaseTest {

    private Logger logger = LogManager.getLogger(FAQTest.class);

    /**
     * Test case to verify that the Help Center page displays the correct header text.
     * <p>
     * Steps performed:
     * 1. Navigate to the Help Center (FAQ) page.
     * 2. Retrieve the header text displayed on the page.
     * 3. Assert that the header text matches the expected "Help Center" string.
     * </p>
     */
    @Test
    public void testFAQPage() {
        HelpCenterPage helpCenterPage = homePage.goToHelpCenterPage();
        logger.info("Opened Help Center (FAQ) page");

        String actualText = helpCenterPage.getNavItemHeaderText();

        String expectedText = "Help Center";
        logger.info("Retrieved actual and expected header text");

        Assert.assertEquals(actualText, expectedText,
                "Header text on Help Center (FAQ) page did not match expected value");

        logger.info("Verified Help Center (FAQ) page header text successfully");
    }
}
