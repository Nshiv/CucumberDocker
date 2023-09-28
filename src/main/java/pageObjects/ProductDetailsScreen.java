package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;
import utilities.GenericUtils;

import java.time.Duration;

public class ProductDetailsScreen
{
    public WebDriver driver;
    public GenericUtils genericUtils;
    public ElementsUtilities elementsUtilities;
    public ProductDetailsScreen(WebDriver driver)
    {
        this.driver= driver;
        genericUtils = new GenericUtils(driver);
        elementsUtilities= new ElementsUtilities(driver);
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    private WebElement categoryName;

    @FindBy(xpath = "//div[@class='product-information']/p[2]")
    private WebElement availability;

    @FindBy(xpath = "//div[@class='product-information']/p[3]")
    private WebElement condition;

    @FindBy(xpath = "//div[@class='product-information']/p[4]")
    private WebElement brand;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(id = "quantity")
    private WebElement product_Quantity;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement btnViewCart;
    //methods

    public boolean getProductNameField()
    {
        try{
        return productName.isDisplayed();
    }catch (NoSuchElementException | ElementNotInteractableException e)
    {
        LoggerHelper.logError("Isuse with the locator "+productName+" "+ e.getMessage() );
    }
     return false;
    }

    public boolean getCategoryNameField()
    {
        try{
            return categoryName.isDisplayed();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Isuse with the locator "+categoryName+" "+ e.getMessage() );
        }
        return false;

    }
    public boolean getAvailabilityField()
    {
        try{
            return availability.isDisplayed();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Isuse with the locator "+availability+" "+ e.getMessage() );
        }
        return false;
    }

    public boolean getConditionField()
    {
        try{
            return  condition.isDisplayed();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Isuse with the locator "+condition+" "+ e.getMessage() );
        }
        return false;
    }

    public boolean getBrandField()
    {
        try{
            return brand.isDisplayed();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Isuse with the locator "+brand+" "+ e.getMessage() );
        }
        return false;
    }

    public boolean getAddtoCartButton()
    {

        try{
            genericUtils.waitForElementToBeVisible(addToCartButton, Duration.ofSeconds(10));
            return addToCartButton.isDisplayed();
        }catch (NoSuchElementException | ElementNotInteractableException e)
        {
            LoggerHelper.logError("Isuse with the locator "+addToCartButton+" "+ e.getMessage() );
        }
        return false;
    }

    public void setProduct_Quantity(String quantity)
    {
        elementsUtilities.clearElement(product_Quantity);
        elementsUtilities.elementSendKeys(product_Quantity,quantity);
    }

    public void clickAddToCartButton()
    {
        elementsUtilities.elementClick(addToCartButton);
    }

    public void clickOnViewCartLink()
    {
        elementsUtilities.elementClick(btnViewCart);
    }

}
