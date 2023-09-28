package parallelStepdefHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logManager.LoggerHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.*;
import utilities.ContextSetUp;

import java.util.List;

public class AddToCart
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ProductsListingScreen productsListingScreen;
    public CartPage cartPage;
    public ProductDetailsScreen productDetailsScreen;
    public AddToCart(ContextSetUp contextSetUp)
    {
      this.contextSetUp = contextSetUp;
      productsListingScreen = contextSetUp.pageObjectManager.getProductsListingScreen();
      homePage= contextSetUp.pageObjectManager.getHomePage();
      cartPage= contextSetUp.pageObjectManager.getCartPage();
      productDetailsScreen= contextSetUp.pageObjectManager.getProductDetailsScreen();
    }


    @And("I Hover over first product")
    public void mouseHoverAndClickOnFirstProduct()
    {
        productsListingScreen.mouseHoverOnElement();
        try {
            Thread.sleep(5000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            LoggerHelper.logException(e.getMessage(),e);
        }
    }

    @And("I click on Add to cart button")
    public void clickOnAddToCartOnMouseHoveredUI()
    {
     productsListingScreen.clickOnAddToCartOnHoverOverlay();
     try {
         Thread.sleep(5000);
     }catch (Exception e)
     {
         LoggerHelper.logException(e.getMessage(),e);
     }
    }

    @And("I Click Continue Shopping button")
    public void clickOnContinueShoppingButtonOnChildWindow()
    {

        //String parentWindowHandle = productsListingScreen.getParentWindowHandle();
        //productsListingScreen.switchToChildWindow();
        //System.out.println(productsListingScreen.getContinueButtonStatus());
        productsListingScreen.clickOnContinueShoppingButton();
        //LoggerHelper.logInfo("Clicked on ContinueShopping button");
       // productsListingScreen.switchToParentWindowHandle(parentWindowHandle);
        homePage.clickOnCartButton();
        try {
            Thread.sleep(5000);
        }catch (Exception e)
        {
            LoggerHelper.logException(e.getMessage(),e);
        }

    }
    @And("And I Click View Cart button")
    public void clickOnCartButton()
    {
        homePage.clickOnCartButton();
        try {
            Thread.sleep(2000);
        }catch (Exception e)
        {
            LoggerHelper.logException(e.getMessage(),e);
        }
    }
    @Then("I Verify product is added to Cart")
    public void verifyProductAddedToCart()
    {
        System.out.println(cartPage.getProductsCountOnCartScreen());
        Assert.assertEquals(1,cartPage.getProductsCountOnCartScreen());
    }

    @Then("I Verify product price")
    public void verifyPrice()
    {
        String actualPrice ="Rs. 500";
     List<WebElement> productPrice= cartPage.getProductsPricePerUnit();
     if(productPrice.isEmpty())
     {
         Assert.fail("No product price in the list");
     }
     else
     {
         String expectedPrice = productPrice.get(0).getText().trim();
         Assert.assertEquals(actualPrice,expectedPrice,"Assertion Failed as expsted:" +
                 " "+expectedPrice +", but actual is "+actualPrice);
     }
    }

    @And("I verify quantity")
    public void verifyQuantity()
    {
        String expected= "1";
        List<WebElement> quantity = cartPage.getProductsQuantityOnCart();
        if(quantity.isEmpty())
        {
            Assert.fail("List is empty");
        }
        else {
            String actual = quantity.get(0).getText().trim();
            Assert.assertEquals(actual,expected,"Assertion failed for Quantuty on cart verification. expected is:" +
                    " "+expected+" and actual is  :"+actual);
        }
    }
    @And("I verify  total price")
    public void verifyTotalPrice()
    {
        String expectedPrice = "Rs. 500";
        List<WebElement> totalPrice = cartPage.getProductsTotalPrice();
        if(totalPrice.isEmpty())
        {
            Assert.fail("List is empty fot Tottal price");
        }
        else
        {
            String actualPrice = totalPrice.get(0).getText().trim();
            Assert.assertEquals(actualPrice,expectedPrice,"Assertion failed for total price verifuication. Expected is " +
                    ": "+expectedPrice+" but found "+actualPrice );
        }
    }

    @When("I click on view product button on homepage screen")
    public void clickOnViewProductButtonOnHomepage()
    {
        homePage.clickOnViewProductButton();
        LoggerHelper.logInfo("Clicked on view product button");
    }

    @When("I increase product quantity to {string}")
    public void increaseProductQuantityOnProductDetailsScreen(String quantity)
    {
        productDetailsScreen.setProduct_Quantity(quantity);
        LoggerHelper.logInfo("Increased product quantity to "+quantity);

    }
    @And("I click on add to cart button")
    public void clickOnAddToCartButton()
    {
        productDetailsScreen.clickAddToCartButton();
        LoggerHelper.logInfo("Cliked on add to Cart button");
    }

    @And("I click on view cart button")
    public void clickOnViewCartButton()
    {
        productDetailsScreen.clickOnViewCartLink();
        LoggerHelper.logInfo("Clicked on view cart button");
    }

    @Then("I verify increased quantity that is {string} is displays on cart screen")
    public void verifyIncreasedProductQuantityOnCartScreen(String quantity)
    {
        try {
            String actual = cartPage.getProductQuantity();
            Assert.assertEquals(actual,quantity);
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion Failed for mismatch quanity on cart screen"+e.getMessage());
        }finally {
            LoggerHelper.logInfo("Assertion Passed for verifying updated quantity");
        }

    }


}
