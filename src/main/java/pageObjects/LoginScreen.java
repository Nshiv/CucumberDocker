package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericUtils;

import java.time.Duration;
import java.util.Arrays;

public class LoginScreen
{
    public WebDriver driver;
    public GenericUtils genericUtils;

    public LoginScreen(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        genericUtils = new GenericUtils(driver);
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
        return  login_signUptexts.getText().toLowerCase().trim();
    }

    public void setSignupName(String userName)
    {
        nameInputField.sendKeys(userName);
    }

    public void setSignupEmail(String signupEmail)
    {
        emailInputField.sendKeys(signupEmail);
    }

    public void clickSignupButton()
    {
        signupButton.click();
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }
    public String getLoginVeificationText()
    {
        return loginTexts.getText().toLowerCase().trim();
    }
    public void setLoginEmail(String email)
    {
        try {
            loginEmail.sendKeys(email);
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logElementNotFoundException(String.valueOf(loginEmail));
        }

    }

    public void setLoginPassword(String password)
    {
        try {
            loginPassword.sendKeys(password);
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logException("Issue with element", e);
        }
    }

    public void clickOnLoginButton()
    {
        try{
            loginButton.click();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logException("Eigther element not presernt or interactable", e);
        }

    }

    public String getErrorMessageOnIncorrectLoginPassword()
    {
        try {
            genericUtils.waitForElementToBeVisible(errorMessageOnInvalidLoginPassword, Duration.ofSeconds(10));
            return  errorMessageOnInvalidLoginPassword.getText();
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logInfo(e.getMessage());
            return null;
        }
    }

    public String getScreenURL()
    {
      return driver.getCurrentUrl();

    }

    public String getErrorMessageForSignupWithRegisteredUser()
    {
        try {
            return errorMessageOnSignupWithRegistereduser.getText();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logException("Element locator issue identify " ,e);
        }
        return null;

    }
}
