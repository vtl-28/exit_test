/*
 * Class name: HomePage
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
 * This class represents the Home Page of the AUT (Application Under Test).
 * It provides methods to navigate to various sections of the site such as
 * Search Input, Sign Up, Cart, Best Sellers, Help Center, Login, Flight Bookings,
 * and Mobiles & Tablets pages. This class follows the Page Object Model (POM)
 * pattern and extends the BasePage class.
 */

package com.ExitTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.ExitTest.Base.BasePage;
import static com.ExitTest.Utilities.JavaScriptActions.scrollToElementJS;
import static com.ExitTest.Utilities.JavaScriptActions.scrollToElementJSWithOffset;

/**
 * HomePage contains locators and actions specific to the
 * home page of the AUT (Application Under Test).
 */
public class HomePage extends BasePage {

    Actions act = new Actions(driver);

    // ============ Locators for UI elements on Home Page ============
    private By searchInput = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
    private By loginNavItem = By.xpath("//a[@href='/account/login?ret=/']");
    private By signUpBtn = By.xpath("//span[@class='_1Mikcj']");
    private By cartNavItem = By.xpath("//a[@class='_3RX0a-']");
//    private By bestSellersNavItem = By.xpath("//a[@class='_3RX0a- _3jeYYh']");
    private By bestSellersNavItem = By.xpath("//a[contains(text(),'Become a Seller')]");
    private By faqNavItem = By.xpath("//a[@aria-label='FAQ']");
    private By loginDialogBtn = By.xpath("//a[@class='_1jKL3b']");
    private By flightsNavItem = By.xpath("//span[contains(text(),'Flight Bookings')]");
    private By mobileTablesNavItem = By.xpath("//span[contains(text(),'Mobiles & Tablets')]");
    private By pressNavItem = By.xpath("//a[@aria-label='Press']");
    private By clearTripNavItem = By.xpath("//a[@aria-label='Cleartrip']");

    
    /**
     * Navigates to the Search Input Box page object.
     *
     * @return SearchInputBox page object
     */
    public SearchInputBox goToSearchInput() {
        scrollToElementJS(searchInput);
        click(searchInput);             
        return new SearchInputBox();
    }

    /**
     * Opens the Sign Up page by hovering over the login nav item and clicking Sign Up.
     *
     * @return SignUpPage page object
     */
    public SignUpPage goToSignUpPage() {
        act.moveToElement(find(loginNavItem)).perform();
        click(signUpBtn);                                
        return new SignUpPage();
    }

    /**
     * Navigates to the Cart page.
     *
     * @return CartPage page object
     */
    public CartPage goToCartPage() {
        click(cartNavItem);
        return new CartPage();
    }

    /**
     * Navigates to the Best Sellers page.
     *
     * @return BestSellersPage page object
     */
    public BestSellersPage goToBestSellersPage() {
        click(bestSellersNavItem);
        return new BestSellersPage();
    }

    /**
     * Navigates to the Help Center page (FAQ section).
     *
     * @return HelpCenterPage page object
     */
    public HelpCenterPage goToHelpCenterPage() {
        scrollToElementJSWithOffset(faqNavItem);
        click(faqNavItem);
        return new HelpCenterPage();
    }

    /**
     * Navigates to the Login page.
     *
     * @return LoginPage page object
     */
    public LoginPage goToLoginPage() {
        click(loginDialogBtn);
        return new LoginPage();
    }

    /**
     * Navigates to the Flight Bookings page.
     *
     * @return FlightBookingsPage page object
     */
    public FlightBookingsPage goToFlightBookingsPage() {
        click(flightsNavItem);
        return new FlightBookingsPage();
    }

    /**
     * Navigates to the Mobiles & Tablets page.
     *
     * @return MobilesTabletsPage page object
     */
    public MobilesTabletsPage goToMobilesTabletsPage() {
        click(mobileTablesNavItem);
        return new MobilesTabletsPage();
    }
    
    
    public PressPage goToPressPage() {
    	scrollToElementJSWithOffset(pressNavItem);
        click(pressNavItem);
    	return new PressPage();
    }
    
    public ClearTripPage goToClearTripPage() {
    	scrollToElementJSWithOffset(clearTripNavItem);
        click(clearTripNavItem);
        
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        
    	return new ClearTripPage();
    }
}
