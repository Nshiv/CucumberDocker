package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.DeletedAccountScreen;
import pageObjects.HomePage;
import pageObjects.LoggedInScreen;
import pageObjects.LoginScreen;
import utilities.ContextSetUp;

public class UserLogin
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public LoggedInScreen loggedInScreen;
    public LoginScreen loginScreen;
    public DeletedAccountScreen deletedAccountScreen;

    public UserLogin(ContextSetUp contextSetUp)
    {
       this.contextSetUp= contextSetUp;
       homePage= contextSetUp.pageObjectManager.getHomePage();
       loggedInScreen = contextSetUp.pageObjectManager.getLoggedInScreen();
       loginScreen = contextSetUp.pageObjectManager.getLoginScreen();
    }

   @Then("I verify homepage Title is {string}")
    public void verifyTitleOfScreen(String expected)
   {
       Assert.assertEquals(expected.toLowerCase().trim(),homePage.getpageTitle().trim().toLowerCase());
   }
   @And("I click on Sign in button")
    public  void userClickonSigninButton()
   {
       homePage.clickOnLoginSignupLink();
   }

   @Then("I verify {string} is visible")
    public void verifyLoginTextsVisibility(String expected)
   {
       Assert.assertEquals(expected.toLowerCase().trim(),loginScreen.getLoginVeificationText());
   }
   @And("I enter correct {string} and {string}")
    public void userEnterEmailAndPassword(String email, String password)
   {
       loginScreen.setLoginEmail(email);
       loginScreen.setLoginPassword(password);
   }
   @And("I click on login button")
    public void userClickOnLoginbutton()
   {
    loginScreen.clickOnLoginButton();
   }

   @Then("I verify Logged as username is visible")
    public void verifyLoggedInUsernameOnScreen()
   {
       String expected = "Logged in as sky".toLowerCase().trim();
       Assert.assertEquals(expected,loggedInScreen.getLoggedUserTexts().trim().toLowerCase());
   }
 /*  @And("I click delete account button")
    public void clickOnDeleteAccountButton()
   {
       loggedInScreen.clickDeleteAccount();
   }
   @Then("I Verify that {string} is visible")
    public void verifySuccessfulAccountDeletion(String expected)
   {
       Assert.assertEquals(expected.toLowerCase().trim(),deletedAccountScreen.getDeletedAcountMessage());
   }*/


}
