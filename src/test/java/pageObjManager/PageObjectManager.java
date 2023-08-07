package pageObjManager;

import org.openqa.selenium.WebDriver;
import pageObjects.LogoHomePage;

public class PageObjectManager
{
    public WebDriver driver;
    public LogoHomePage logoHomePage;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public LogoHomePage getLogoHomePage()
    {
        return logoHomePage= new LogoHomePage(driver);
    }


}
