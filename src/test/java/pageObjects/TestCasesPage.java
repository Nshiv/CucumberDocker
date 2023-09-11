package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    public WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        try {
            return textVerificationOnTestCasesScreen.getText();
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the LOcator "+textVerificationOnTestCasesScreen+ "  "+e.getMessage());
        }
       return null;
    }

}
