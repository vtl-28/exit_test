/*
 * Class name: SearchInputBox
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
 * This class represents the Search Input Box section of the AUT.
 * It provides methods to enter text into the search bar, initiate a search,
 * and retrieve the searched product information.
 */

package com.ExitTest.Pages;

import static com.ExitTest.Utilities.WaitActions.explicitWaitUntilVisible;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

import org.openqa.selenium.By;

/**
 * SearchInputBox contains locators and actions related to searching products.
 * It allows entering a search term, clicking the search button, and retrieving
 * search results.
 */
public class SearchInputBox extends HomePage {

    // ============ Locators ============
    private By searchBtn = By.xpath("//button[@title='Search for Products, Brands and More']");
    private By searchInput = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
    private By foundProduct = By.xpath("//div[normalize-space()='Apple iPhone 16 (Teal, 128 GB)']");

    // ============ Methods ============

    /**
     * Enters the provided text into the search input field.
     *
     * @param item The item to be searched.
     */
    public void fillInSearchInput(String item) {
        set(searchInput, item);
    }

    /**
     * Clicks the search button to perform the search action.
     */
    public void searchproduct() {
        click(searchBtn);
    }

    /**
     * Retrieves the name of the found product from the search results.
     * Uses an explicit wait to ensure the element is visible before retrieving its text.
     *
     * @return The name of the found product as a String.
     */
    public String getFoundProducts() {
        explicitWaitUntilVisible(2, foundProduct);
        String product = getElementText(foundProduct);
        return product;
    }
}
