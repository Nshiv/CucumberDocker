package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInScreen
{
    public WebDriver driver;
    public LoggedInScreen(WebDriver driver)
    {
        this.driver=driver;
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
        linkDeleteAccount.click();
    }

    public String getLoggedUserTexts()
    {
        return loggedInUsername.getText();
    }

    public void clickOnLogout()
    {
        try {
            logoutLink.click();
        }catch (NoSuchElementException e)
        {
            LoggerHelper.logException("Issue with logout link locator", e);
        }

    }
}
