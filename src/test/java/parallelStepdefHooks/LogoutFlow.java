package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoggedInScreen;
import pageObjects.LoginScreen;
import utilities.ContextSetUp;

public class LogoutFlow
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public LoginScreen loginScreen;
    public LoggedInScreen loggedInScreen;
    public LogoutFlow(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        loginScreen=contextSetUp.pageObjectManager.getLoginScreen();
        loggedInScreen= contextSetUp.pageObjectManager.getLoggedInScreen();
    }

    @Then("I validate homepage Title is {string} is displays")
    public void verifyHomepageNavigation(String expected)
    {
        Assert.assertEquals(homePage.getpageTitle().trim().toLowerCase(),expected.toLowerCase().trim());
        LoggerHelper.logInfo("Verified homepage title");
    }
    @And("I click on Sign in button on homepage")
    public  void clickOnSigninButton()
    {
        homePage.clickOnLogin_SignupLink();
        LoggerHelper.logInfo("Clicked on signup link");
    }
    @Then("I validate {string} is visible")
    public void verifyTextsOnLoginScreen(String expected)
    {
        Assert.assertEquals(expected.toLowerCase().trim(),loginScreen.getLoginVeificationText().trim().toLowerCase());
        LoggerHelper.logInfo("Validated texts for login on login screen");
    }
    @And("I enter valid {string} and {string}")
    public void enterEmailAndPassword(String email, String password)
    {
     loginScreen.setLoginEmail(email);
     loginScreen.setLoginPassword(password);
     LoggerHelper.logInfo("Email and password provided");
    }
    @And("I click login button")
    public void clickOnLoginButton()
    {
        loginScreen.clickOnLoginButton();
        LoggerHelper.logInfo("Clicked on login button");
    }
    @Then("I validate Logged as username is visible")
    public void verifyCorrectUserName()
    {
        String expected = "Logged in as sky".toLowerCase().trim();
        System.out.println(loggedInScreen.getLoggedUserTexts());
        Assert.assertEquals(expected,loggedInScreen.getLoggedUserTexts().trim().toLowerCase());
        LoggerHelper.logInfo("Verified username of loggedin User");
    }
    @And("I click on logout button")
    public void clickOnLogout()
    {
      loggedInScreen.clickOnLogout();
      LoggerHelper.logInfo("clicked on logout button");
    }
    @Then("I verift that i am navigated to login screen again")
    public void verifyNavigationOnLoginScreen()
    {
     String NavigatedPage = "https://www.automationexercise.com/login";
     Assert.assertEquals(NavigatedPage,loginScreen.getScreenURL().trim());
     LoggerHelper.logInfo("Verified navigation of login screen again");
    }
}
