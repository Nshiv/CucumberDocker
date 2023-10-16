package parallelStepdefHooks;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.ProductDetailsScreen;
import utilities.ContextSetUp;

import java.awt.dnd.DropTargetAdapter;
import java.util.List;
import java.util.Map;

public class AddReviewsStepDef
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ProductDetailsScreen productDetailsScreen;

    public AddReviewsStepDef(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        productDetailsScreen= contextSetUp.pageObjectManager.getProductDetailsScreen();
    }

    @Then("I verify {string} is visible on product details screen")
    public void verifyTextsOnProductDetailsScreen(String texts)
    {
        Assert.assertEquals(texts.toLowerCase(),productDetailsScreen.getWriteYourReviewTexts());
    }

    @And("I enter following details in review section")
    public void setFormValuesForProductReview(DataTable dataTable)
    {
        List<Map<String,String>> values = dataTable.asMaps();
        for(Map<String,String> data : values)
        {
            String name = data.get("name");
            String emailAddress = data.get("email");
            String reviewTexts = data.get("review");
            productDetailsScreen.setTextYourName(name);
            productDetailsScreen.setTextEmail(emailAddress);
            productDetailsScreen.setTextAddReview(reviewTexts);
        }
    }

    @And("I click on Submit button on screen")
    public void clickOnSubmitButton() {
        productDetailsScreen.clickOnSubmitReviewButton();

    }
}
