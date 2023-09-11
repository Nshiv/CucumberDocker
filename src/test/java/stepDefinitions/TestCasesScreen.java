package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.TestCasesPage;
import utilities.ContextSetUp;

import java.util.logging.Logger;

public class TestCasesScreen
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public TestCasesPage testCasesPage;
    public TestCasesScreen(ContextSetUp contextSetUp)
    {
       this.contextSetUp= contextSetUp;
       homePage= contextSetUp.pageObjectManager.getHomePage();
       testCasesPage= contextSetUp.pageObjectManager.getTestCasesPage();
    }

    @Then("I Verify that home page is visible successfully with title {string}")
    public void verifyPaheTitle(String expected)
    {
        try {
            Assert.assertEquals(expected.toLowerCase().trim(),homePage.getpageTitle().toLowerCase().trim());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion failed for verifying title"+e.getMessage());
        }
        LoggerHelper.logInfo("Title verified");

    }
    @And("I  Click on Test Cases button")
    public void clickOnTestCaseButton()
    {
        homePage.clickOnTestCaseButton();
        LoggerHelper.logInfo("Test case button clicked");
    }
    @Then("I  Verify user is navigated to test cases page successfully")
    public void verifyNavigatedToTestCaseScreen()
    {
        try {
            String expected = "TEST CASES";
            Assert.assertEquals(expected.toLowerCase().trim(),testCasesPage.getVerificationTexts().toLowerCase().trim());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion Failed for verifying texts on testcases screen"+e.getMessage());
        }
        LoggerHelper.logInfo("Verified assertion for Test case screen redirection");

    }
}
