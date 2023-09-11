package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class PaymentSuccessScreen
{
    public WebDriver driver;
    public ElementsUtilities elementsUtilities;
    public PaymentSuccessScreen(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        elementsUtilities= new ElementsUtilities(driver);
    }

    //LOcators

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement message_successMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement btn_continue;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    private WebElement btn_downloadInvoice;

    //methods

    public String getOrderSuccessTexts()
    {
        return  elementsUtilities.getTextsOfElement(message_successMessage);
    }

    public void clickContinueButtonOnOrderSuccess()
    {
        elementsUtilities.elementClick(btn_continue);
    }

    public void clikDownloadInvoice()
    {
        elementsUtilities.elementClick(btn_downloadInvoice);
    }

}
