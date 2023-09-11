package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.HomePage;
import utilities.ContextSetUp;
import utilities.GenericUtils;

public class Subscription
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public Subscription(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
    }

    @Then("I scroll down to footer")
    public void scrollDownToFooterSection()
    {
      homePage.scrollToFooterWidget();
    }
    @Then("I verify text {string} on footer")
    public void verifySubscriptionTexts(String expected)
    {
        try {
            Assert.assertEquals(expected.toLowerCase().trim(),homePage.getSubscriptionText().trim().toLowerCase());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion Failed" +e.getMessage());
        }
    }

    @And("I enter {string} address as input")
    public void enterEmailId(String email)
    {
        homePage.setSubscriptionEmail(email);
    }

    @And("I click on arrow button")
    public void clickOnArraowButton()
    {
        homePage.clickOnArrowbutton();
    }

    @Then("I verify success message {string} is visible")
    public void verifySuccessMessageOnSubmitSubscription(String expected)
    {
        try {
            Assert.assertEquals(expected.trim().toLowerCase(),homePage.getSubscriptionText().toLowerCase().trim());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion Failed while verifying success message on submit subscription "+e.getMessage());
        }
    }
    @And("I click Cart button")
    public void clickOnCartPage()
    {
        homePage.clickOnCartButton();
    }
}
