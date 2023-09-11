package utilities;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils
{
    public WebDriver driver;
    public Actions actions;
    public  GenericUtils(WebDriver driver)
    {
        this.driver=driver;
        actions = new Actions(driver);
    }

    public String getParentWindowHandle()
    {
        return driver.getWindowHandle();
    }
    public void switchWindowToChild()
    {

        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        }
    }

    public void switchToParentWindow(String parentWindow)
    {
        driver.switchTo().window(parentWindow);
    }


    public void acceptAlert()
    {

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }catch (NoAlertPresentException e)
        {
            LoggerHelper.logError("No alert present "+e.getMessage());
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

   /* public void mouseHoverAndClick(WebElement element)
    {
        actions.moveToElement(element).click().build().perform();
    }*/

    public void mouseHover(WebElement element)
    {

        actions.moveToElement(element).perform();
    }

    public void clickElement(WebElement element)
    {

        actions.click(element).build().perform();
    }
    public void waitForElementToBeClickable(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
