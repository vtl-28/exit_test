/*
 * Class name: PressTest
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
 * This test class verifies that an article on the Press page 
 * opens successfully and displays the expected headline text.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.PressPage;

/**
 * Test class to validate navigation to the Press page and confirm
 * that an article opens successfully with the expected headline text.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and 
 * the initialized HomePage object.
 * </p>
 */
public class PressTest extends BaseTest {

    private Logger logger = LogManager.getLogger(PressTest.class);

    /**
     * Test case to verify that an article on the Press page opens successfully 
     * and the headline text matches the expected value.
     * <p>
     * Steps performed:
     * 1. Navigate to the Press page from the Home page.
     * 2. Open (read) the article on the Press page.
     * 3. Retrieve the headline text of the opened article.
     * 4. Assert that the headline text matches the expected value.
     * </p>
     */
    @Test
    public void testArticleOpensSuccessfully() {
        PressPage pressPage = homePage.goToPressPage();
        logger.info("Opened Press page");

        pressPage.readArticle();
        logger.info("Opened and read article on Press page");

        String actualArticleHeaderText = pressPage.getArticleHeadlineText();
        String expectedArticleHeaderText = "TBBD Throwback: The Big Billion Day 2015!";

        Assert.assertEquals(actualArticleHeaderText, expectedArticleHeaderText,
                "The article headline text did not match the expected value");

        logger.info("Verified Press page article headline text successfully");
    }
}
