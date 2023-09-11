package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class CheckoutScreen
{
    public WebDriver driver;
    public ElementsUtilities elementsUtilities;
    public CheckoutScreen(WebDriver driver)
    {
        this.driver= driver;
        elementsUtilities= new ElementsUtilities(driver);
        PageFactory.initElements(driver,this);

    }

    //Locators

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement inputComment;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement btnPlaceOrder;

    //methods

    public void setComments(String comments)
    {
        elementsUtilities.elementSendKeys(inputComment,comments);
    }

    public void clickPlaceOrder()
    {
        elementsUtilities.elementClick(btnPlaceOrder);
    }



}
