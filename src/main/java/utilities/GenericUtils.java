package utilities;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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
        try {
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }catch (NoSuchWindowException e)
        {
            LoggerHelper.logError("Issue in between switching to child window>>>"+e.getMessage());
        }

    }

    public void switchToParentWindow(String parentWindow)
    {
        try {
            driver.switchTo().window(parentWindow);
        }catch (NoSuchWindowException e)
        {
            LoggerHelper.logError("Issue in switching back to parent window>>>"+e.getMessage());
        }

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
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }catch (NoSuchElementException e)
        {
            LoggerHelper.logError("Issue in locator >>"+element+" >>>"+e.getMessage());
        }

    }

    public void mouseHover(WebElement element)
    {try {
        actions.moveToElement(element).perform();
    }catch (ElementNotInteractableException | NoSuchElementException e)
    {
        LoggerHelper.logError("Error on hover on locator >>"+element+"   >>>"+e.getMessage());
    }

    }

    public void clickElement(WebElement element)
    {
        try {
            actions.click(element).build().perform();
    }catch (NoSuchElementException e)
        {
            LoggerHelper.logError("Error on peforming click on element >>>>"+element+" >>>"+e.getMessage());
        }

    }
    public void waitForElementToBeClickable(WebElement element, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e)
        {
            LoggerHelper.logError("Unable to interact/locate element to click  >>>"+element+"  >>>"+e.getMessage());
        }

    }

    public void waitForElementToBeVisible(WebElement element, Duration timeout) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e)
        {
            LoggerHelper.logError("element is not visible  >>>"+element+"  >>>"+e.getMessage());
        }

    }

}
