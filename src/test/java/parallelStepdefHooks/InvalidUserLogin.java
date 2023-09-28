package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginScreen;
import utilities.ContextSetUp;

public class InvalidUserLogin
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public LoginScreen loginScreen;

    public InvalidUserLogin(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        loginScreen = contextSetUp.pageObjectManager.getLoginScreen();
    }

    @Then("I verify redirected homepage Title is {string} is present")
    public void verifyHomepageTitle(String expected)
    {
        Assert.assertEquals(expected.toLowerCase().trim(),homePage.getpageTitle().trim().toLowerCase());
    }
    @And("I click on Sign-in button")
    public void clickOnSignInButton()
    {
        homePage.clickOnLogin_SignupLink();
    }
    @Then("I verify {string} is visible on navigated screen")
    public void verifySignInTextONScreen(String expected)
    {
        Assert.assertEquals(expected.toLowerCase().trim(),loginScreen.getLoginVeificationText().trim().toLowerCase());
    }
    @Then("I enter in-correct {string} and {string}")
    public void enterIncorrectEmailPassword(String email, String password)
    {
        loginScreen.setLoginEmail(email);
        loginScreen.setLoginPassword(password);
    }
    @And("I click on log-in button")
    public void clickOnLoginButton()
    {
        loginScreen.clickOnLoginButton();
    }
    @Then("I verify corresponding error message on screen")
    public void verifyErrorMessageOnScreen()
    {
        String errorMessage = "Your email or password is incorrect!".toLowerCase();
        Assert.assertEquals(errorMessage,loginScreen.getErrorMessageOnIncorrectLoginPassword().trim().toLowerCase());
    }


}
