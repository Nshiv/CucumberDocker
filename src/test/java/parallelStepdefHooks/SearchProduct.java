package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.ProductsListingScreen;
import utilities.ContextSetUp;

import java.util.List;

public class SearchProduct
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;
    public ProductsListingScreen productsListingScreen;
    public SearchProduct(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
        productsListingScreen= contextSetUp.pageObjectManager.getProductsListingScreen();
    }

    @Then("I Enter {string} in search input")
    public void enterSearchKeywordInSearchBar(String searchInput)
    {
        productsListingScreen.setSearchInput(searchInput);
    }
    @And("I click on search button")
    public void clickOnSearchButton()
    {
        productsListingScreen.clickSearchButton();
    }
    @Then("I Verify {string} is present in product Titles")
    public void verifyTitleOneachDisplayedResult(String expectedTitle)
    {
        boolean flag = true;
        List<WebElement> titles = productsListingScreen.getProductsTitle();
        for(WebElement titleElement : titles)
        {
            String actualTitle = titleElement.getText();
            System.out.println(actualTitle);
            if(!actualTitle.contains(expectedTitle))
            {
                flag=false;
                break;
            }
        }
            Assert.assertTrue(flag);


    }
}
