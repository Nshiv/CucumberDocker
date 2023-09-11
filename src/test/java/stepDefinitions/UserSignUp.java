package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logManager.LoggerHelper;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utilities.ContextSetUp;
import java.util.List;
import java.util.Map;

public class UserSignUp
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public LoginScreen loginScreen;
    public SignupFormScreen signupFormScreen;
    public SignUpSuccessScreen signUpSuccessScreen;
    public LoggedInScreen loggedInScreen;
    public DeletedAccountScreen deletedAccountScreen;
    public UserSignUp(ContextSetUp contextSetUp)
    {
        this.contextSetUp=contextSetUp;
        homePage=contextSetUp.pageObjectManager.getHomePage();
        loginScreen=contextSetUp.pageObjectManager.getLoginScreen();
        signupFormScreen= contextSetUp.pageObjectManager.getSignupFormScreen();
        signUpSuccessScreen= contextSetUp.pageObjectManager.getSignUpSuccessScreen();
        loggedInScreen= contextSetUp.pageObjectManager.getLoggedInScreen();
        deletedAccountScreen=contextSetUp.pageObjectManager.getDeletedAccountScreen();
    }
    @Given("I navigated to homepage")
    public void navigatedToHomepage()
    {
      LoggerHelper.logInfo("Browser launched and navigated to Url");
    }
    @Then("I verify that homepage Title is {string}")
    public void verifyHomepageTitle(String title)
    {
        LoggerHelper.logInfo("Starting page title assertion");

        try {
            Assert.assertEquals(title.toLowerCase().trim(),homePage.getpageTitle().trim().toLowerCase());
        }catch (AssertionError e)
        {
           LoggerHelper.logAssertionError( "Assertion Failed for verifying homepage Title",e);
        }
        LoggerHelper.logInfo("Assertion completed");
    }
    @When("I click on the SignUp button")
    public void clickOnSignUpButton()
    {
        homePage.clickOnLogin_SignupLink();
        LoggerHelper.logInfo("Signup b-utton is clicked.");
    }
    @Then("I verify that {string} is visible")
    public void validateTextsOnSignupScreen(String expected)
    {
        LoggerHelper.logInfo("Assertion for validation texts on signup screen is started");
        try {
            String actualTexts=loginScreen.getTextsForSignUp();
            Assert.assertEquals(actualTexts.toLowerCase().trim(),expected.trim().toLowerCase());
        }catch (AssertionError e)
        {
            LoggerHelper.logAssertionError("Assertion failed for validationg textx on signup screen",e);
        }
        LoggerHelper.logInfo("Assertion completed");

    }

    @When("I enter valid name and email address")
    public void enterValidNameAndEmail(DataTable dataTable)
    {
        LoggerHelper.logInfo("Starting enter email and email for sign up");
        List<Map<String,String>> userDetails = dataTable.asMaps(String.class,String.class);
        for(Map<String,String> values : userDetails)
        {
            String name = values.get("name");
            String user_email = values.get("email");
            loginScreen.setSignupName(name);
            loginScreen.setSignupEmail(user_email);
        }
        LoggerHelper.logInfo("Details entered on screen");
    }

    @And("I click the Signup button")
    public void clickedOnSignupButton()
    {
        loginScreen.clickSignupButton();
        LoggerHelper.logInfo("Clicked on signup button");
    }

    @Then("I verify texts {string} is visible on signup form")
    public void verifyTextsOnSignupForm(String expectedTexts)
    {
        LoggerHelper.logInfo("Assertion about to start for verifying screentexts on signup form screen");
        try {
            Assert.assertEquals(expectedTexts.toLowerCase().trim(),signupFormScreen.getSignupTexts().toLowerCase().trim());
        }catch (AssertionError e)
        {
           LoggerHelper.logAssertionError("Assertion failed for validating texts on signUpform screen",e);
        }
        LoggerHelper.logInfo("Assertion completed");
    }

    @When("i click title radioButton as Mr.")
    public void selectUserTitle()
    {
        signupFormScreen.clickMrRadioButton();
        LoggerHelper.logInfo("Radio button as mr. on signup form");
    }

    @When("I fill the following details")
    public void fillUpUserDetails(DataTable dataTable)
    {
        LoggerHelper.logInfo("Initiating userinfo to enter on signup form");
      List<Map<String,String>> records = dataTable.asMaps(String.class,String.class);
      for(Map<String,String> details : records)
      {
          String password = details.get("Password");
          String dob = details.get("Date_of_Birth");
          signupFormScreen.setPassword(password);
          signupFormScreen.setDaysInDOB(dob);
          signupFormScreen.setMonthInDOB(dob);
          signupFormScreen.setYearInDOB(dob);
          LoggerHelper.logInfo("Password,dob entered on screen");
      }
    }
    @And("I select the checkbox Sign up for our newsletter")
    public void selectNewsLetterCheckBox()
    {
        //signupFormScreen.clickNewsletter();
        LoggerHelper.logInfo("News letter checkbox checked");
    }
    @And("I select the checkbox Receive special offers from our partners")
    public void selectSpecialOfferCheckBox()
    {
       // signupFormScreen.clikSpecialOffers();
        LoggerHelper.logInfo("special offers checkbox checked");
    }
    @And("I fill the following additional details:")
    public void enterAllFormDetails(DataTable dataTable)
    {
        LoggerHelper.logInfo("Initiating further user details on signup form screen");
     List<Map<String,String>> details = dataTable.asMaps(String.class,String.class);
     for(Map<String,String> inputs : details)
     {
         String  first_name = inputs.get("FirstName");
         String  last_name = inputs.get("LastName");
         String  company = inputs.get("Company");
         String  address1 = inputs.get("Address1");
         String  address2 = inputs.get("Address2");
         String  country = inputs.get("Country");
         String  state = inputs.get("State");
         String  city = inputs.get("City");
         String  zip = inputs.get("Zipcode");
         String  phone = inputs.get("MobileNumber");

         signupFormScreen.setFirstName(first_name);
         signupFormScreen.setLastName(last_name);
         signupFormScreen.setCompany(company);
         signupFormScreen.setTextFieldAddress1(address1);
         signupFormScreen.setTextFieldAddress2(address2);
         signupFormScreen.selectCountry(country);
         signupFormScreen.setState(state);
         signupFormScreen.setZipcode(zip);
         signupFormScreen.setMobileNUmber(phone);
         signupFormScreen.setTextFieldCity(city);
         LoggerHelper.logInfo("Other information entered on form");

     }
    }
    @And("I click the Create Account button")
    public void clickCreateUserAccountButton()
    {
        signupFormScreen.clickOnSubmitForm();
        LoggerHelper.logInfo("Clicked on create account button");
    }
    @And("I verify texts {string} is visible")
    public void verifyUserSignup(String expected)
    {
        try {
            Assert.assertEquals(signUpSuccessScreen.getSignUpSucesstexts().trim().toLowerCase(),expected.trim().toLowerCase());
        }catch (AssertionError e)
        {
            LoggerHelper.logAssertionError("Assertion failed for verifying texts",e);
        }
    }

    @When("I click the Continue button")
    public void clickContinueButton()
    {
        signUpSuccessScreen.clickContinuebutton();
        LoggerHelper.logInfo("Clicked on continue button on signUpscuccess screen");
    }

    @When("I click the Delete Account button")
    public void cliclDeleteAccount()
    {
        loggedInScreen.clickDeleteAccount();
        LoggerHelper.logInfo("Clicked on delete account button on loggedinScreen");
    }
    @Then("I verify that {string} is displays")
    public void verifyAccountDeletion(String expected)
    {
        try {
            String actual = deletedAccountScreen.getDeletedAcountMessage();
            System.out.println(actual);
            Assert.assertEquals(expected.trim().toLowerCase(),actual.trim().toLowerCase());
        }catch (AssertionError e)
        {
            LoggerHelper.logAssertionError("Assertion failed for Texts verification on deletedsignupSCreen",e);
        }
    }

    @Then("I click the Continue button on screen")
    public void clickOnContinueButton()
    {
        deletedAccountScreen.clickContinueButton();
        LoggerHelper.logInfo("Clicked on continue button and its end of this stepdefinition file [Scenario: User Signup]");
    }
  // Starting of second scenario

    @Then("I verify that homepage Title is {string} displays on screen")
    public void verifyTextsOnScreen(String expected)
    {
        Assert.assertEquals(expected.trim().toLowerCase(),homePage.getpageTitle().trim().toLowerCase());
        LoggerHelper.logInfo("Assertion completed for verifying Title of the homepage");
    }
    @And("I click on the SignUp button on screen")
    public void clickOnSignUpbutton()
    {
        homePage.clickOnLogin_SignupLink();
    }

    @And("I Enter already registered {string} and {string} for signup")
    public void enterRegisteredUsernameAndEmail(String username, String email)
    {
        loginScreen.setSignupName(username);
        loginScreen.setSignupEmail(email);
    }
    @And("I click the Signup button to validate")
    public void clickOnSignUpButtonOnScreen()
    {
        loginScreen.clickSignupButton();
    }
    @Then("I verify that {string} is visible on screen")
    public void validateTextsOnSignUpScreen(String expected)
    {
     Assert.assertEquals(expected.trim().toLowerCase(),loginScreen.getTextsForSignUp().toLowerCase().trim());
    }
    @Then("I Verify error {string} is visible")
    public void verifyErrorMessageOnscreen(String expected)
    {
      String actual =loginScreen.getErrorMessageForSignupWithRegisteredUser().trim().toLowerCase();
      System.out.println(actual);
      Assert.assertEquals(expected.trim().toLowerCase(),actual);
    }
}
