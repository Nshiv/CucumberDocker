package pageObjManager;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import utilities.ElementsUtilities;

public class PageObjectManager
{
    public WebDriver driver;
    public HomePage homePage;
    public LoginScreen loginScreen;
    public SignupFormScreen signupFormScreen;
    public SignUpSuccessScreen signUpSuccessScreen;
    public LoggedInScreen loggedInScreen;
    public DeletedAccountScreen deletedAccountScreen;
    public ContactUsForm contactUsForm;
    public TestCasesPage testCasesPage;
    public ProductsListingScreen productsListingScreen;
    public ProductDetailsScreen productDetailsScreen;
    public HandleNewWindowOnLaunch handleNewWindowOnLaunch;
    public CartPage cartPage;
    public CheckoutScreen checkoutScreen;
    public PaymentScreen paymentScreen;

    public PaymentSuccessScreen paymentSuccessScreen;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public HomePage getHomePage()
    {
        return homePage= new HomePage(driver);
    }
    public LoginScreen getLoginScreen()
    {
        return loginScreen = new LoginScreen(driver);
    }

    public SignupFormScreen getSignupFormScreen()
    {
        return signupFormScreen = new SignupFormScreen(driver);
    }
    public SignUpSuccessScreen getSignUpSuccessScreen()
    {
        return  signUpSuccessScreen = new SignUpSuccessScreen(driver);
    }
    public LoggedInScreen getLoggedInScreen()
    {
        return  loggedInScreen = new LoggedInScreen(driver);
    }
    public DeletedAccountScreen getDeletedAccountScreen()
    {
        return  deletedAccountScreen= new DeletedAccountScreen(driver);
    }
    public ContactUsForm getContactUsForm()
    {
        return contactUsForm = new ContactUsForm(driver);
    }
    public TestCasesPage getTestCasesPage()
    {
        return testCasesPage= new TestCasesPage(driver);
    }
    public ProductDetailsScreen getProductDetailsScreen()
    {
        return productDetailsScreen= new ProductDetailsScreen(driver);
    }

    public ProductsListingScreen getProductsListingScreen()
    {
        return productsListingScreen = new ProductsListingScreen(driver);
    }

    public HandleNewWindowOnLaunch getHandleNewWindowOnLaunch()
    {
        return handleNewWindowOnLaunch= new HandleNewWindowOnLaunch((driver));
    }

    public CartPage getCartPage()
    {
        return cartPage= new CartPage((driver));
    }
    public CheckoutScreen getCheckoutScreen()
    {
        return checkoutScreen = new CheckoutScreen(driver);
    }

    public PaymentScreen getPaymentScreen()
    {
        return paymentScreen = new PaymentScreen(driver);
    }

    public PaymentSuccessScreen getPaymentSuccessScreen()
    {
       return paymentSuccessScreen = new PaymentSuccessScreen(driver);
    }



}
