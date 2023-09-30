package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;
import utilities.GenericUtils;

import java.time.Duration;
import java.util.Arrays;

public class LoginScreen
{
    public WebDriver driver;
    public GenericUtils genericUtils;
    private ElementsUtilities elementsUtilities;

    public LoginScreen(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        genericUtils = new GenericUtils(driver);
        elementsUtilities = new ElementsUtilities(driver);
    }

    //locators

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement login_signUptexts;

    @FindBy(name = "name")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginTexts;

    @FindBy(xpath="//input[@data-qa ='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa ='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa ='login-button']")
    private  WebElement loginButton;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    private WebElement errorMessageOnInvalidLoginPassword;

    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    private WebElement errorMessageOnSignupWithRegistereduser;

    //methods

    public String getTextsForSignUp()
    {
        return  elementsUtilities.getTextsOfElement(login_signUptexts).trim().toLowerCase();
    }

    public void setSignupName(String userName)
    {
        elementsUtilities.elementSendKeys(nameInputField,userName);
    }

    public void setSignupEmail(String signupEmail)
    {
       elementsUtilities.elementSendKeys(emailInputField,signupEmail);
    }

    public void clickSignupButton()
    {
      elementsUtilities.elementClick(signupButton);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }
    public String getLoginVeificationText()
    {
      return  elementsUtilities.getTextsOfElement(loginTexts).trim().toLowerCase();
    }
    public void setLoginEmail(String email)
    {
        elementsUtilities.elementSendKeys(loginEmail,email);
    }

    public void setLoginPassword(String password)
    {
        elementsUtilities.elementSendKeys(loginPassword,password);
    }

    public void clickOnLoginButton()
    {
       elementsUtilities.elementClick(loginButton);
    }

    public String getErrorMessageOnIncorrectLoginPassword()
    {
            genericUtils.waitForElementToBeVisible(errorMessageOnInvalidLoginPassword, Duration.ofSeconds(10));
            return  elementsUtilities.getTextsOfElement(errorMessageOnInvalidLoginPassword);
    }

    public String getScreenURL()
    {
      return driver.getCurrentUrl();

    }

    public String getErrorMessageForSignupWithRegisteredUser()
    {
       return elementsUtilities.getTextsOfElement(errorMessageOnSignupWithRegistereduser);
    }
}
