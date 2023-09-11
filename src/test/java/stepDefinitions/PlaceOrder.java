package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.*;
import utilities.ContextSetUp;

import java.util.List;
import java.util.Map;

public class PlaceOrder
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ProductsListingScreen productsListingScreen;
    public CheckoutScreen checkoutScreen;
    public PaymentScreen paymentScreen;
    public CartPage cartPage;
    public PaymentSuccessScreen paymentSuccessScreen;
    public PlaceOrder(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        productsListingScreen= contextSetUp.pageObjectManager.getProductsListingScreen();
        paymentScreen= contextSetUp.pageObjectManager.getPaymentScreen();
        checkoutScreen= contextSetUp.pageObjectManager.getCheckoutScreen();
        cartPage= contextSetUp.pageObjectManager.getCartPage();
        paymentSuccessScreen= contextSetUp.pageObjectManager.getPaymentSuccessScreen();
    }

    @When("I add product to cart and Navigated to cart page")
    public void addProductToCart()
    {
      productsListingScreen.mouseHoverOnElement();
      productsListingScreen.clickOnAddToCartOnHoverOverlay();
      LoggerHelper.logInfo("Add to cart clicked");
      productsListingScreen.clickOnviewCartLink();
      LoggerHelper.logInfo("Clicked on view cart");

    }

   @When("I click on proceed to checkout")
    public void clickOnProceedToCheckout()
   {
    cartPage.clickProceedToCheckOutBtn();
    LoggerHelper.logInfo("Clicked on checkout button on cart details screen");
   }

   @When("I enter description texts in comment texts area")
    public void enterDescriptionTexts()
   {
       String comments = "yest comments";
       checkoutScreen.setComments(comments);
       LoggerHelper.logInfo("Comment provided in comment field");
   }

   @And("I click on Place order")
    public void clickOnPlaceOrder()
   {
       checkoutScreen.clickPlaceOrder();
       LoggerHelper.logInfo("PLace order clicked");
   }

   @When("I enter payment details")
    public void setPaymentDetails(DataTable dataTable)
   {
       List<Map<String, String>> paymentDetailes = dataTable.asMaps(String.class, String.class);
       for(Map<String, String> details : paymentDetailes)
       {
           String nameOnCard = details.get("Name on card");
           String cardNumber = details.get("Card number");
           String cvc = details.get("CVC");
           String month_exp= details.get("Expiration month");
           String year_exp = details.get("Expiration Year");

           paymentScreen.setNameOnCard(nameOnCard);
           paymentScreen.setCardNumber(cardNumber);
           paymentScreen.setCVC(cvc);
           paymentScreen.setExpirayMonth(month_exp);
           paymentScreen.setExpiryYear(year_exp);
       }
       LoggerHelper.logInfo("All the Payment details completely submitted");
   }
    @And("Click pay and confirm order button")
    public void clickOnPayAndConfirmOrder()
   {
       paymentScreen.clickConfirmOrder();
       LoggerHelper.logInfo("Clicked on confirm order");
   }

   @Then("I verify success message on screen as {string}")
    public void verifySuccessMessageOnPayment(String expected)
   {
       String actual = paymentSuccessScreen.getOrderSuccessTexts().trim().toLowerCase();
       Assert.assertEquals(expected.trim().toLowerCase(),actual);
       LoggerHelper.logInfo("Assertions done");
   }

}
