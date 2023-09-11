package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.ProductDetailsScreen;
import pageObjects.ProductsListingScreen;
import utilities.ContextSetUp;

public class ProductDetails
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ProductDetailsScreen productDetails;
    public ProductsListingScreen productsListingScreen;
    public ProductDetails(ContextSetUp contextSetUp)
    {
       this.contextSetUp = contextSetUp;
       homePage= contextSetUp.pageObjectManager.getHomePage();
       productDetails= contextSetUp.pageObjectManager.getProductDetailsScreen();
       productsListingScreen = contextSetUp.pageObjectManager.getProductsListingScreen();
    }

    @Then("Verify home page is visible with {string} as Title")
    public void verifyHomepageTitle(String expected)
    {
        try {
            Assert.assertEquals(expected.trim().toLowerCase(),homePage.getpageTitle().trim().toLowerCase());
        }catch (AssertionError e )
        {
           LoggerHelper.logError("Assertion failed for verifying page title of homepage"+ e.getMessage());
        }
        LoggerHelper.logInfo("Assertion completed for homepage");
    }

    @And("I Click on Products button")
    public void clickOnProductButton()
    {
        homePage.clickOnProductsButton();
        LoggerHelper.logInfo("clicked on products button");
    }

    @Then("I Verify navigation with {string} texts present on product Listing screen")
    public void verifyTextsOnProductListingScreen(String expected)
    {
        try {
            Assert.assertEquals(expected.trim().toLowerCase(),productsListingScreen.getVerificationTexts().trim().toLowerCase());
        }catch (AssertionError e )
        {
            LoggerHelper.logError("Assertion failed for verifying page title of homepage"+ e.getMessage());
        }
        LoggerHelper.logInfo("Assertion completed for homepage");
    }

    @And("I Click on View Product of first product on product listing")
    public void clickOnFirstProductToViewProduct()
    {
        System.out.println("Starting of 1 method ");
        productsListingScreen.clickOnFirstProduct();
        LoggerHelper.logInfo("clicked on first product to view product details");

    }

    @Then("I verify User is landed to product detail page")
    public void verifyLandingOnProductDetailsScreen()
    {
        try {
            Assert.assertTrue(productDetails.getAddtoCartButton());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion failed for getting add to cartButton"+e.getMessage());

        }
        LoggerHelper.logInfo("Assertion Complete to verify product details screen");
    }
    @Then("I Verify  product name, category, price, availability, condition, brand are visible")
    public void verifyProductElementsOnScreen()
    {
        try {
            Assert.assertTrue(productDetails.getProductNameField());
            Assert.assertTrue(productDetails.getCategoryNameField());
            Assert.assertTrue(productDetails.getConditionField());
            Assert.assertTrue(productDetails.getAvailabilityField());
            Assert.assertTrue(productDetails.getBrandField());

        }catch (AssertionError e)
        {
            LoggerHelper.logError("One of the assertion failed");
        }

    }

}
