package pageObjects;

import logManager.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;
import utilities.GenericUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsListingScreen
{
    public WebDriver driver;
    public GenericUtils genericUtils;
    public ElementsUtilities elementsUtilities;
    public ProductsListingScreen(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        genericUtils = new GenericUtils(driver);
        elementsUtilities= new ElementsUtilities(driver);
    }

    //Locators
    @FindBy(xpath = "//h2[contains(.,'All Products')]")
    private WebElement verificationTextOnProductScreen;

    @FindBy(xpath = "//img[@src=\"/get_product_picture/1\"]")
    private WebElement scrollToViewElement;

    @FindBy(xpath = "//a[normalize-space()='View Cart']")
    private WebElement link_viewCart;

    @FindBy(id = "search_product")
    private WebElement search_bar;

    @FindBy(id = "submit_search")
    private WebElement btn_search;

    @FindAll(
            {
                    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
            }
    )
    private List<WebElement> productsTitle;

    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")
    private WebElement btnAddToCartOnMouseHover;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement btnContinueShopping;



   //methods

    public String getVerificationTexts()
    {
        try {
            return verificationTextOnProductScreen.getText();
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the Locator >>" +verificationTextOnProductScreen+ ">>"+e.getMessage());
        }
        return null;
    }

    public void clickOnFirstProduct()
    {

        try {
            genericUtils.scrollIntoView(scrollToViewElement);
            scrollToViewElement.click();
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the Locator >>" +scrollToViewElement+e.getMessage());
        }
    }

    public void setSearchInput(String input)
    {
        try {
            search_bar.sendKeys(input);
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the Locator >>" +search_bar+e.getMessage());
        }
    }

    public void clickSearchButton()
    {
        try {
            btn_search.click();
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the Locator >>" +btn_search+e.getMessage());
        }
    }

    public List<WebElement> getProductsTitle()
    {
        try {
            return productsTitle;
        }catch (ElementNotInteractableException | NoSuchElementException e)
        {
            LoggerHelper.logError("Issue with the Locator >>" +btn_search+e.getMessage());
        }
        return null;
    }

    public void clickOnAddToCartOnHoverOverlay()
    {
      genericUtils.waitForElementToBeVisible(btnAddToCartOnMouseHover,Duration.ofSeconds(10));
      if(btnAddToCartOnMouseHover.isDisplayed())
      {
          btnAddToCartOnMouseHover.click();
      }
      else
      {
          System.out.println("Not displays"+ btnAddToCartOnMouseHover.isDisplayed());
          LoggerHelper.logError("Unable to click as elemtn not present");
      }

    }

    public void mouseHoverOnElement()
    {
        LoggerHelper.logInfo("Waiting for element to view");
        genericUtils.waitForElementToBeVisible(scrollToViewElement,Duration.ofSeconds(10));
        LoggerHelper.logInfo("Scroll to view started");
        genericUtils.scrollIntoView(scrollToViewElement);
        LoggerHelper.logInfo("Scrolling done");
        genericUtils.mouseHover(scrollToViewElement);
        LoggerHelper.logInfo("Mouse hover done");

    }

    public void switchToChildWindow()
    {
        genericUtils.switchWindowToChild();
    }

    public void clickOnContinueShoppingButton()
    {try {
        genericUtils.waitForElementToBeClickable(btnContinueShopping,Duration.ofSeconds(10));
        if(btnContinueShopping.isDisplayed())
        {
            btnContinueShopping.click();
        }

    }catch (Exception e)
    {
        LoggerHelper.logError("Issue with the locator"+btnContinueShopping+" "+e.getMessage());
    }

    }

    public String getParentWindowHandle()
    {
       return genericUtils.getParentWindowHandle();
    }

    public void switchToParentWindowHandle(String parent)
    {
        genericUtils.switchToParentWindow(parent);
    }

    public boolean getContinueButtonStatus()
    {
        return btnContinueShopping.isDisplayed();
    }

    public boolean getStatusOfAddToCartButton()
    {
        return btnAddToCartOnMouseHover.isDisplayed();
    }
    public void clickOnviewCartLink()
    {
        elementsUtilities.elementClick(link_viewCart);
    }


}
