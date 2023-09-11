package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsForm {
    public WebDriver driver;

    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        try {
            return getInTouchText.getText();
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
        return null;
    }

    public void setName(String name) {
        try {
            textName.sendKeys(name);
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }

    public void setEmail(String email) {
        try {
            textEmail.sendKeys(email);
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }

    public void setSubject(String subject) {
        try {
            textSubject.sendKeys(subject);
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }

    public void setMessage(String message) {
        try {
            textMessage.sendKeys(message);
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }

    public void setUpload() {
        try {
            String filePath ="D:\\TestUploadFiles\\Books+API.pdf";
            uploadFile.sendKeys(filePath);
        }catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e)
        {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }


    }

    public void clickSubmitButton() {
        try {
            btnSubmit.click();
        } catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }

    public String getUploadSuccessTexts()
    {
        try {
            return textUploadSuccess.getText();
        }catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
        return null;
    }

    public void clickOnHomeButton()
    {
        try {
            btnHome.click();
        }catch (NoSuchElementException | InvalidSelectorException | ElementNotInteractableException e) {
            LoggerHelper.logInfo("Issue with the locator " + e.getMessage());
        }
    }
}
