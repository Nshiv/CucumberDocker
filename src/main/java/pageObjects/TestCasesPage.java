package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class TestCasesPage {
    public WebDriver driver;
    private ElementsUtilities elementsUtilities;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementsUtilities= new ElementsUtilities(driver);
    }

    //Locators

    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement textVerificationOnTestCasesScreen;
    //Methods
    public String getPageTitle()
    {
        return getPageTitle();
    }

    public String getVerificationTexts()
    {
            return elementsUtilities.getTextsOfElement(textVerificationOnTestCasesScreen);
    }

}
