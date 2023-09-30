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
        elementsUtilities.elementClick(login_Signuplink);
    }

    public String getpageTitle()
    {
        return  driver.getTitle();
    }
    public void clickOnContactUsButton()
    {
        elementsUtilities.elementClick(button_contactus);
    }

    public void clickOnTestCaseButton()
    {
         elementsUtilities.elementClick(btnTestCases);
    }

    public void clickOnProductsButton()
    {
        elementsUtilities.elementClick(btnProducts);
    }

    public void scrollToFooterWidget()
    {
        genericUtils.scrollIntoView(footerWidget);
    }

    public String getSubscriptionText()
    {
        return elementsUtilities.getTextsOfElement(subscriptionText);
    }

    public void setSubscriptionEmail(String email)
    {
        elementsUtilities.elementSendKeys(textEnterEmail,email);
    }

    public void clickOnArrowbutton()
    {
       elementsUtilities.elementClick(btnArrowSubscription);
    }

    public String getSuccessSubscriptionMessage()
    {
        return elementsUtilities.getTextsOfElement(subscriptionSuccessMessage);
    }

    public void clickOnCartButton()
    {
        genericUtils.waitForElementToBeClickable(btnCart, Duration.ofSeconds(5));
        elementsUtilities.elementClick(btnCart);
    }

    public void clickOnViewProductButton()
    {
       elementsUtilities.elementClick(viewProductButton);
    }
}