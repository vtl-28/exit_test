/*
 * Class name: PressPage
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
 * This class represents the Press Page of the AUT (Application Under Test).
 * It contains locators and methods to interact with the press articles, 
 * such as reading an article and retrieving its headline.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;

import static com.ExitTest.Utilities.WaitActions.explicitWaitUntilVisible;
import static com.ExitTest.Utilities.GetElementTextActions.getElementText;

/**
 * PressPage contains locators and actions specific to the Press section
 * of the AUT. It allows interaction with press articles including clicking 
 * the "Read More" button and verifying article headlines.
 */
public class PressPage extends HomePage {

    // ============ Locators ============
    private By readMoreBtn = By.xpath(
        "//article[@id='post-72719']//p[@class='ast-blog-single-element ast-read-more-container read-more']//a[1]"
    );
    private By articleHeadline = By.xpath("//h1[@class='entry-title']");

    // ============ Methods ============

    /**
     * Clicks the "Read More" button to open the article and waits until the article headline is visible.
     * Uses an explicit wait for better synchronization.
     */
    public void readArticle() {
        click(readMoreBtn);
        explicitWaitUntilVisible(3, articleHeadline);
    }

    /**
     * Retrieves the text of the article headline.
     *
     * @return The headline text as a String
     */
    public String getArticleHeadlineText() {
        String text = getElementText(articleHeadline);
        return text;
    }
}
