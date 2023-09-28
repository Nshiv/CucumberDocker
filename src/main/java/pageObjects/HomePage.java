package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;
import utilities.GenericUtils;

import java.time.Duration;

public class HomePage
{
    public WebDriver driver;
    public GenericUtils genericUtils;
    public ElementsUtilities elementsUtilities;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        genericUtils = new GenericUtils(driver);
        elementsUtilities= new ElementsUtilities(driver);
        PageFactory.initElements(driver,this);
    }
    //Locators
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement login_Signuplink;

    @FindBy(xpath = "//li/a[contains(.,'Contact us')]")
    private WebElement button_contactus;

    @FindBy(xpath = "//a[text()=' Test Cases']")
    private WebElement btnTestCases;

    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement btnProducts;

    @FindBy(xpath = "//div[@class='footer-widget']")
    private WebElement footerWidget;

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement textEnterEmail;

    @FindBy(id = "subscribe")
    private WebElement btnArrowSubscription;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement subscriptionSuccessMessage;

    @FindBy(xpath = "//a[text()=' Cart']")
    private WebElement btnCart;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductButton;


    //Methods
    public void clickOnLogin_SignupLink()
    {
        login_Signuplink.click();
    }

    public String getpageTitle()
    {
        return  driver.getTitle();
    }
    public void clickOnContactUsButton()
    {
        try {
            button_contactus.click();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logInfo("Issue with contact us locator "+button_contactus);
        }
    }

    public void clickOnTestCaseButton()
    {
        try {
            btnTestCases.click();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logInfo("Issue with contact us locator "+btnTestCases);
        }
    }

    public void clickOnProductsButton()
    {
        try {
            btnProducts.click();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Issues with the locator "+btnProducts + "  "+ e.getMessage());
        }
    }

    public void scrollToFooterWidget()
    {
        try {
            genericUtils.scrollIntoView(footerWidget);
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Issues with the locator "+footerWidget + "  "+ e.getMessage());
        }

    }

    public String getSubscriptionText()
    {
        try
         {
        return subscriptionText.getText();
         }catch (NoSuchElementException | ElementNotInteractableException e)
    {
        LoggerHelper.logError("Issues with the locator "+subscriptionText + "  "+ e.getMessage());
    }
    return null;
    }

    public void setSubscriptionEmail(String email)
    {
        try {
            textEnterEmail.sendKeys(email);
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Issues with the locator "+textEnterEmail + "  "+ e.getMessage());
        }
    }

    public void clickOnArrowbutton()
    {
        try {
            btnArrowSubscription.click();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Issues with the locator "+btnArrowSubscription + "  "+ e.getMessage());
        }
    }

    public String getSuccessSubscriptionMessage()
    {
        try {
           return subscriptionSuccessMessage.getText();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Issues with the locator "+subscriptionSuccessMessage + "  "+ e.getMessage());
        }
        return null;
    }

    public void clickOnCartButton()
    {
        try {
            genericUtils.waitForElementToBeClickable(btnCart, Duration.ofSeconds(5));
        btnCart.click();
    }catch (NoSuchElementException | ElementNotInteractableException e)
    {
        LoggerHelper.logError("Issues with the locator "+btnCart + "  "+ e.getMessage());
    }
    }

    public void clickOnViewProductButton()
    {
       elementsUtilities.elementClick(viewProductButton);
    }
}
