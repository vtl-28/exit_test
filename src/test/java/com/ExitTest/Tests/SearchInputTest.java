/*
 * Class name: SearchInputTest
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
 * This test verifies the search functionality on the AUT by entering a product name
 * in the search box and validating the search result.
 */

package com.ExitTest.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ExitTest.Base.BaseTest;
import com.ExitTest.Pages.SearchInputBox;

/**
 * Test class to validate the search input functionality on the application under test.
 * <p>
 * Extends {@link BaseTest} to inherit WebDriver setup/teardown and the initialized HomePage object.
 * </p>
 */
public class SearchInputTest extends BaseTest {
    public Logger logger = LogManager.getLogger(SearchInputTest.class);

    /**
     * Test case to verify that a search for a product returns the expected result.
     * <p>
     * Steps performed:
     * 1. Navigate to the search input box from the home page.
     * 2. Enter a product name in the search input box.
     * 3. Initiate the search.
     * 4. Retrieve the search results.
     * 5. Assert that the retrieved product matches the expected product.
     * </p>
     *
     * @param searchItem the product name to be searched, supplied via TestNG XML or defaulted to "mobiles".
     */
    @Test
    @Parameters("searchItem")
    public void testVerifySearchFunctionality(@Optional("mobiles") String searchItem) {
        SearchInputBox searchPage = homePage.goToSearchInput();
        logger.info("Navigated to the search input box");

        searchPage.fillInSearchInput(searchItem);
        logger.info("Entered item in search box: " + searchItem);

        searchPage.searchproduct();
        logger.info("Triggered search for the item");

        String actualProductFound = searchPage.getFoundProducts();

        String expectedProductFound = "Apple iPhone 16 (Teal, 128 GB)";
        logger.info("Retrieved actual and expected product values");

        Assert.assertEquals(actualProductFound, expectedProductFound,
                "The product found does not match the expected product");
        logger.info("Verified search functionality successfully");
    }
}
