/*
 * Class name: OfferZoneTest
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
 * This test class verifies navigation to the Offer Zone page
 * from the Mobiles & Tablets page and checks that the page header 
 * text matches the expected value.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.MobilesTabletsPage;
import com.ExitTest.Pages.OffersPage;

/**
 * Test class to validate navigation from the Mobiles & Tablets page
 * to the Offers (Offer Zone) page and confirm that the correct header
 * text appears on the Offers page.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and 
 * the initialized HomePage object.
 * </p>
 */
public class OfferZoneTest extends BaseTest {

    private Logger logger = LogManager.getLogger(OfferZoneTest.class);

    /**
     * Test case to verify that the Offer Zone page can be accessed
     * from the Mobiles & Tablets page and displays the correct header text.
     * <p>
     * Steps performed:
     * 1. Navigate to the Mobiles & Tablets page from the home page.
     * 2. From Mobiles & Tablets page, navigate to the Offer Zone page.
     * 3. Retrieve the header text from the Offer Zone page.
     * 4. Assert that the retrieved header text matches the expected value.
     * </p>
     */
    @Test
    public void testOfferZonePage() {
        MobilesTabletsPage mobileTabletsPage = homePage.goToMobilesTabletsPage();
        logger.info("Opened Mobiles & Tablets page");

        OffersPage offersPage = mobileTabletsPage.goToOffersPage();
        logger.info("Opened Offer Zone page from Mobiles & Tablets");

        String actualText = offersPage.getHeaderText();

        String expectedText = "Top Deals";

        Assert.assertEquals(actualText, expectedText,
                "The Offer Zone page header text did not match the expected value");

        logger.info("Verified Offer Zone page header text successfully");
    }
}
