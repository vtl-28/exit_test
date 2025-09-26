/*
 * Class name: MobilesTabletsTest
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
 * This test class verifies that the Mobiles & Tablets page displays 
 * the expected header text when accessed from the home page.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.MobilesTabletsPage;

/**
 * Test class to validate navigation to the Mobiles & Tablets page and
 * check that the correct header text is displayed.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and 
 * the initialized HomePage object.
 * </p>
 */
public class MobilesTabletsTest extends BaseTest {

    private Logger logger = LogManager.getLogger(MobilesTabletsTest.class);

    /**
     * Test case to verify that the Mobiles & Tablets page is opened successfully
     * and displays the correct header text.
     * <p>
     * Steps performed:
     * 1. Navigate to the Mobiles & Tablets page from the home page.
     * 2. Retrieve the header text from the page.
     * 3. Assert that the retrieved header text matches the expected value.
     * </p>
     */
    @Test
    public void testMobilesTabletsPage() {
        MobilesTabletsPage mobileTabletsPage = homePage.goToMobilesTabletsPage();
        logger.info("Opened Mobiles & Tablets page");

        String actualText = mobileTabletsPage.mobilePhonesHeaderText();

        String expectedText = "Mobile Phones";
        logger.info("Retrieved actual and expected header texts");

        Assert.assertEquals(actualText, expectedText,
                "The Mobiles & Tablets page header text did not match the expected value");

        logger.info("Verified Mobiles & Tablets page header text successfully");
    }
}
