package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pageObjects.LogoHomePage;
import utilities.ContextSetUp;

public class LogoStepDefinitionTest
{
    public ContextSetUp contextSetUp;
    public LogoHomePage logoHomePage;

    public LogoStepDefinitionTest(ContextSetUp contextSetUp)
    {
        this.contextSetUp=contextSetUp;
        logoHomePage=contextSetUp.pageObjectManager.getLogoHomePage();
    }
    SoftAssert sa = new SoftAssert();


    @Given("User is on HomePage with {string}")
    public void navigateToHomePage(String title)
    {
        String actual =logoHomePage.getPageTitle();
        sa.assertEquals(actual.toLowerCase().trim(),title.toLowerCase().trim());
        System.out.println("Actual is : "+ actual+" Expected is "+ title);
    }

    @When("User browse header section of page")
    public boolean is_logo_present()
    {
        boolean status =logoHomePage.logoImageStatus();
        return status;
    }

    @Then("Company logo should be present")
    public void validate_logo_status_on_homepage()
    {
        sa.assertTrue(is_logo_present());
    }


}
