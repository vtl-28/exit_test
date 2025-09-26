/*
 * Class name: NotificationsTest
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
 * This test class verifies that the Notifications page can be opened
 * from the Help Center and displays the expected header text.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.HelpCenterPage;
import com.ExitTest.Pages.NotificationsPage;

/**
 * Test class to validate navigation from the Help Center page
 * to the Notifications page and confirm that the correct header text
 * appears on the Notifications page.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and 
 * the initialized HomePage object.
 * </p>
 */
public class NotificationsTest extends BaseTest {

    private Logger logger = LogManager.getLogger(NotificationsTest.class);

    /**
     * Test case to verify that the Notifications page can be accessed
     * from the Help Center page and displays the correct header text.
     * <p>
     * Steps performed:
     * 1. Navigate to the Help Center page from the home page.
     * 2. From Help Center, navigate to the Notifications page.
     * 3. Retrieve the header text from the Notifications page.
     * 4. Assert that the retrieved header text matches the expected value.
     * </p>
     */
    @Test
    public void testNotficationsPage() {
        HelpCenterPage helpCenterPage = homePage.goToHelpCenterPage();
        logger.info("Opened Help Center page");

        NotificationsPage notificationsPage = helpCenterPage.goToNotificationsPage();
        logger.info("Opened Notifications page from Help Center");

        String actualText = notificationsPage.getHeaderText();

        String expectedText = "Desktop Notifications";
        logger.info("Retrieved actual and expected header text values");

        Assert.assertEquals(actualText, expectedText,
                "The Notifications page header text did not match the expected value");

        logger.info("Verified Notifications page header text successfully");
    }
}
