package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericUtils;

public class HandleNewWindowOnLaunch
{
    public WebDriver driver;
    public GenericUtils genericUtils;
    public HandleNewWindowOnLaunch(WebDriver driver)
    {
        this.driver= driver;
        genericUtils= new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    public void setParentWindow() {
        String parent = genericUtils.getParentWindowHandle();
        genericUtils.switchWindowToChild();
        driver.close();
        genericUtils.switchToParentWindow(parent);
    }
}
