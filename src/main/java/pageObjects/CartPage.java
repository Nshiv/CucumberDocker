package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

import java.util.ArrayList;
import java.util.List;

public class CartPage
{
    public WebDriver driver;
    public ElementsUtilities elementsUtilities;
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        elementsUtilities=new ElementsUtilities(driver);
        PageFactory.initElements(driver,this);
    }
    //locators
    @FindAll({ @FindBy(xpath = "//img[contains(@src,'get_product_picture/')]")})
    private List<WebElement> productImagesOnCart;
    @FindAll({ @FindBy(xpath = "//td[@class='cart_price']")})
    private List<WebElement> productsPricePerUnit;
    @FindAll({@FindBy(xpath = "//p[@class='cart_total_price']")})
    private List<WebElement> productTotalPrice;
    @FindAll({@FindBy(xpath = "//button[@class='disabled']")})
    private List<WebElement> productsQuantity;

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    private WebElement productQuantity;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement btnProceedToCheckout;





    //Methods

    public List<WebElement> getProductImagesOnCart()
    {
        return productImagesOnCart;
    }

    public List<WebElement> getProductsQuantityOnCart()
    {
        return productsQuantity;
    }

    public List<WebElement> getProductsPricePerUnit()
    {
        return productsPricePerUnit;
    }

    public List<WebElement> getProductsTotalPrice()
    {
       return productTotalPrice;
    }

    public int getProductsCountOnCartScreen()
    {
        List<WebElement> products = productImagesOnCart;
        return products.size();
    }

    public String getProductQuantity()
    {
       return elementsUtilities.getTextsOfElement(productQuantity);
    }

    public void clickProceedToCheckOutBtn()
    {
        elementsUtilities.elementClick(btnProceedToCheckout);
    }


}
