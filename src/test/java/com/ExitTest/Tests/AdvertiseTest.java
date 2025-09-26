/*
 * Class name: AdvertiseTest
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
 * This test class validates that a user must log in before they can access 
 * the "Advertise" page from the Help Center in the AUT.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.AdvertisePage;
import com.ExitTest.Pages.HelpCenterPage;

/**
 * Test class for verifying the login requirement when accessing the Advertise page.
 * <p>
 * This class extends BaseTest to inherit WebDriver setup/teardown functionality.
 * It performs navigation from the Home page to Help Center and then to Advertise page
 * and asserts the login requirement message.
 * </p>
 */
public class AdvertiseTest extends BaseTest {

    private Logger logger = LogManager.getLogger(AdvertiseTest.class);

    
    /**
     * Test case to verify that a user must log in before accessing the Advertise page.
     * <p>
     * Steps performed:
     * 1. Navigate to Help Center page.
     * 2. Navigate to Advertise page from Help Center.
     * 3. Validate the displayed message asking the user to log in.
     * </p>
     */
    @Test
    public void testThatUserHasToLoginFirstBeforeAccessingAdvertisePage() {
        HelpCenterPage helpCenterPage = homePage.goToHelpCenterPage();
        logger.info("Opened Help Center page");

        AdvertisePage advertisePage = helpCenterPage.goToAdvertisePage();
        logger.info("Opened Advertise page");

        String actualText = advertisePage.getLoginText();
        String expectedText = "Please enter in your credentials to login";
        logger.info("Retrieved actual and expected login prompt text");

        Assert.assertEquals(actualText, expectedText);
        logger.info("Verified that login is required before accessing Advertise page");
    }
}
