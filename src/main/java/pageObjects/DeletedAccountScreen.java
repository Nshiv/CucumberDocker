package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class DeletedAccountScreen
{
    public WebDriver driver;
    private ElementsUtilities elementsUtilities;

    public DeletedAccountScreen(WebDriver driver)
    {
       this.driver = driver;
       PageFactory.initElements(driver,this);
       elementsUtilities= new ElementsUtilities(driver);
    }

    //elements

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement textDeleteaccount;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement btnContinue;

    //methofds

    public String getDeletedAcountMessage()
    {
       return elementsUtilities.getTextsOfElement(textDeleteaccount);
    }

    public void clickContinueButton()
    {
       elementsUtilities.elementClick(btnContinue);
    }


}
