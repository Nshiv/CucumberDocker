package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.HomePage;
import utilities.ContextSetUp;
import utilities.GenericUtils;

public class ScrollStepDef
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public GenericUtils genericUtils;

   public ScrollStepDef(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage=contextSetUp.pageObjectManager.getHomePage();
    }

    @And("I click on scroll up button")
    public void clickOnScrollUpButton() {
     homePage.clickOnScrollUpButton();
    }

    @Then("I verify {string} texts are displays on homepage screen")
    public void verifyTextsOnBanner(String bannerText) {
        Assert.assertEquals(bannerText.toLowerCase(),homePage.getBannerTexts().toLowerCase());
    }

    @And("I scroll up manually to top of the screen")
    public void scrollUpWithoutArrowButton()
    {
        try {
            homePage.scrollUpTillBanner();
        }catch (RuntimeException e)
        {
            Assert.fail("Test case failed due to an Issue with locator or Utility method");
        }
    }
}

