package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;


public class ContactUsForm {
    public WebDriver driver;
    public ElementsUtilities elementsUtilities;

    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementsUtilities= new ElementsUtilities(driver);
    }

    //Locators
    @FindBy(name = "name")
    private WebElement textName;

    @FindBy(name = "email")
    private WebElement textEmail;

    @FindBy(name = "subject")
    private WebElement textSubject;

    @FindBy(id = "message")
    private WebElement textMessage;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFile;

    @FindBy(name = "submit")
    private WebElement btnSubmit;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElement getInTouchText;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement textUploadSuccess;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement btnHome;

    //Methods

    public String getTextsOnContactUs() {
        return elementsUtilities.getTextsOfElement(getInTouchText);
    }

    public void setName(String name) {
       elementsUtilities.elementSendKeys(textName,name);
    }

    public void setEmail(String email) {
            elementsUtilities.elementSendKeys(textEmail,email);
    }

    public void setSubject(String subject) {
            elementsUtilities.elementSendKeys(textSubject,subject);
    }

    public void setMessage(String message) {
          elementsUtilities.elementSendKeys(textMessage,message);
    }

    public void setUpload() {
            String filePath ="D:\\TestUploadFiles\\Books+API.pdf";
            elementsUtilities.elementSendKeys(uploadFile,filePath);
    }

    public void clickSubmitButton() {
          elementsUtilities.elementClick(btnSubmit);
    }

    public String getUploadSuccessTexts()
    {
        return elementsUtilities.getTextsOfElement(textUploadSuccess);
    }

    public void clickOnHomeButton() {
        elementsUtilities.elementClick(btnHome);
    }
}
