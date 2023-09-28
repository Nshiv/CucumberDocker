package parallelStepdefHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import logManager.LoggerHelper;
import org.testng.Assert;
import pageObjects.ContactUsForm;
import pageObjects.HomePage;
import utilities.ContextSetUp;
import utilities.GenericUtils;

import java.util.List;
import java.util.Map;

public class ContactUs
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ContactUsForm contactUsForm;
    public GenericUtils genericUtils;
    public ContactUs(ContextSetUp contextSetUp)
    {
        this.contextSetUp = contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        contactUsForm= contextSetUp.pageObjectManager.getContactUsForm();
    }

    @And("I click on Contact us button")
    public void clickOnContactUsButton()
    {
        homePage.clickOnContactUsButton();
    }
    @Then("I verift {string} is visible")
    public void verifyTextsOnContactUsScreen(String expected)
    {
        try {
            Assert.assertEquals(expected.toLowerCase().trim(),contactUsForm.getTextsOnContactUs().trim().toLowerCase());
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion failed for Verification texts on Contact us form  "+ e.getMessage());
        }

    }

    @And("I enter following details on screen")
    public void enterFormInputs(DataTable dataTable)
    {
        try {
        List<Map<String, String>> formDetails = dataTable.asMaps(String.class,String.class);
        for(Map<String,String> details : formDetails)
        {
            //Fething inputs from keys of maps from feature file
            String nameInput = details.get("name");
            String emailInput = details.get("email");
            String subjectInput = details.get("subject");
            String messageInput = details.get("message");
            // proving inputs to driver
            contactUsForm.setName(nameInput);
            contactUsForm.setEmail(emailInput);
            contactUsForm.setSubject(subjectInput);
            contactUsForm.setMessage(messageInput);
        }
    }catch (Exception e)
        {
            LoggerHelper.logError("Method : enterFormInputs"+e.getMessage());
        }
    }

    @And("I uploads a file")
    public void uploadFileOnContactUsForm()
    {
        contactUsForm.setUpload();
    }

    @And("I click on submit button")
    public void clickOnsubmitButton()
    {
        contactUsForm.clickSubmitButton();
    }

    @And("I click on ok button")
    public void acceptAlert()
    {
        LoggerHelper.logInfo("Alert Handling started");
        contextSetUp.genericUtils.acceptAlert();
        LoggerHelper.logInfo("Alert Handleled");
    }

    @And("I Verify success message {string} is visible")
    public void verifySuccessMessageOnContactUsFormSubmission(String expected)
    {
        try {
            String successmessage = contactUsForm.getUploadSuccessTexts().trim().toLowerCase();
            System.out.println(successmessage);
            Assert.assertEquals(expected.trim().toLowerCase(),successmessage);
        }catch (AssertionError e)
        {
            LoggerHelper.logError("Assertion failed on Verifying Texts on upload success"+e.getMessage());
        }
    }

    @And("I click on home button")
    public void clickOnHomeButton()
    {
        contactUsForm.clickOnHomeButton();
    }

    @Then("I verify navigation on homepage")
    public void verifyHomePageScreen()
    {try {
        String pagetitle = "Automation Exercise";
        Assert.assertEquals(pagetitle.trim().toLowerCase(),homePage.getpageTitle().toLowerCase().trim());
    }catch (AssertionError e)
    {
        LoggerHelper.logError("Assertion failed for verifying homepage navigation after contact us form"+e.getMessage());
    }

    }
}
