package utilities;

import logManager.LoggerHelper;
import org.openqa.selenium.*;

import java.util.List;

public class ElementsUtilities
{
    public WebDriver driver;
    public ElementsUtilities(WebDriver driver)
    {
        this.driver= driver;
    }

    public  void  elementClick(WebElement element)
    {
        try {
            element.click();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with clicking on " + element + ": " + e.getMessage());
        }
    }

    public void elementSendKeys(WebElement element, String input)
    {
        try {
            element.sendKeys(input);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with sending keys to " + element + ": " + e.getMessage());
        }
    }

    public boolean elementIsDisplays(WebElement element)
    {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + element + ": " + e.getMessage());
            return false;
        }
    }

    public boolean elementIsSelected(WebElement element)
    {
        try {
            return element.isSelected();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + element + ": " + e.getMessage());
            return false;
        }
    }

    public boolean elementIsEnabled(WebElement element)
    {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + element + ": " + e.getMessage());
            return false;
        }
    }

    public void clearElement(WebElement element)
    {
        try {
            element.clear();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + element + ": " + e.getMessage());
        }
    }

    public List<WebElement> getElementsAsList(List<WebElement> elements)
    {
        try {
            return elements;
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + elements + ": " + e.getMessage());
        }
        return null;
    }

    public int getSizeOfListofElements(List<WebElement> elements)
    {
        try {
            return elements.size();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + elements + ": " + e.getMessage());
        }
        return 0;
    }

    public String getTextsOfElement(WebElement element)
    {
        try {
           return element.getText();
        }catch (NoSuchElementException | ElementNotInteractableException e) {
            LoggerHelper.logError("Issues with checking visibility of " + element + ": " + e.getMessage());
        }
        return null;

    }


}
