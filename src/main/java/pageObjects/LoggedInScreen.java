package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class LoggedInScreen
{
    public WebDriver driver;
    private ElementsUtilities elementsUtilities;
    public LoggedInScreen(WebDriver driver)
    {
        this.driver=driver;
        elementsUtilities= new ElementsUtilities(driver);
        PageFactory.initElements(driver,this);
    }

    //elements
    @FindBy(xpath = "//li/a[contains(., 'Logged in as')]")
    private WebElement loggedInUsername;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement linkDeleteAccount;

    @FindBy(xpath = "//li/a[contains(.,'Logout')]")
    private WebElement logoutLink;
    //methods

    public void clickDeleteAccount()
    {
       elementsUtilities.elementClick(linkDeleteAccount);
    }

    public String getLoggedUserTexts()
    {
      return  elementsUtilities.getTextsOfElement(loggedInUsername);
    }

    public void clickOnLogout()
    {
        elementsUtilities.elementClick(logoutLink);
    }
}
