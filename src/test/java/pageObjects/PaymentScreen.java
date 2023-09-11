package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

import java.nio.file.Path;

public class PaymentScreen
{
    public WebDriver driver;
    public ElementsUtilities elementsUtilities;
    public PaymentScreen(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        elementsUtilities = new ElementsUtilities(driver);
    }

    //locators

    @FindBy(xpath = "//input[@name='name_on_card']")
    private WebElement input_NameOnCard;

    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement input_CardNumber;

    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement input_cvc;

    @FindBy(xpath = "//input[@name='expiry_month']")
    private  WebElement input_expirymonth;

    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement input_expiryYear;

    @FindBy(id = "submit")
    private WebElement btn_payAndconfirmOrder;

    //methods

    public void setNameOnCard(String name)
    {
        elementsUtilities.elementSendKeys(input_NameOnCard,name);
    }

    public void setCardNumber(String cardNumber)
    {
        elementsUtilities.elementSendKeys(input_CardNumber, cardNumber);
    }

    public void setCVC(String cvc)
    {
        elementsUtilities.elementSendKeys(input_cvc, cvc);
    }

    public void setExpirayMonth(String month)
    {
        elementsUtilities.elementSendKeys(input_expirymonth,month);
    }

    public  void setExpiryYear(String year)
    {
        elementsUtilities.elementSendKeys(input_expiryYear, year);
    }

    public void clickConfirmOrder()
    {
        elementsUtilities.elementClick(btn_payAndconfirmOrder);
    }
}
