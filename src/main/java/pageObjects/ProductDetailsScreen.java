package pageObjects;
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

    @FindBy(xpath = "//a[@href='#reviews']")
    private WebElement textWriteYourReview;

    @FindBy(css = "#name")
    private WebElement textYourName;

    @FindBy(css = "#email")
    private WebElement textEmail;

    @FindBy(css = "textarea#review")
    private WebElement textAddReview;

    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement btnSubmitReview;

    @FindBy(xpath = "//span[normalize-space()='Thank you for your review.']")
    private WebElement messageSuccessReview;
    //methods

    public boolean getProductNameField()
    {
        return elementsUtilities.elementIsDisplays(productName);
    }

    public boolean getCategoryNameField()
    {
       return elementsUtilities.elementIsDisplays(categoryName);

    }
    public boolean getAvailabilityField()
    {
        return elementsUtilities.elementIsDisplays(availability);
    }

    public boolean getConditionField()
    {
        return elementsUtilities.elementIsDisplays(condition);
    }

    public boolean getBrandField()
    {
       return elementsUtilities.elementIsDisplays(brand);
    }

    public boolean getAddtoCartButton()
    {
            genericUtils.waitForElementToBeVisible(addToCartButton, Duration.ofSeconds(10));
            return elementsUtilities.elementIsDisplays(addToCartButton);
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

    public String getWriteYourReviewTexts()
    {
       return elementsUtilities.getTextsOfElement(textWriteYourReview).trim().toLowerCase();
    }

    public void setTextYourName(String name)
    {
        elementsUtilities.elementSendKeys(textYourName,name);
    }

    public void setTextEmail(String email)
    {
        elementsUtilities.elementSendKeys(textEmail,email);
    }

    public void setTextAddReview(String reviewTexts)
    {
        elementsUtilities.elementSendKeys(textAddReview,reviewTexts);
    }

    public void clickOnSubmitReviewButton()
    {
        elementsUtilities.elementClick(btnSubmitReview);
    }

    public String getSuccessReviewMessage()
    {
        genericUtils.waitForElementToBeVisible(messageSuccessReview,Duration.ofSeconds(5));
        return elementsUtilities.getTextsOfElement(messageSuccessReview);
    }


}
