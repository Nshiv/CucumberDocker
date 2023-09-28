package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletedAccountScreen
{
    public WebDriver driver;

    public DeletedAccountScreen(WebDriver driver)
    {
       this.driver = driver;
       PageFactory.initElements(driver,this);
    }

    //elements

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement textDeleteaccount;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement btnContinue;

    //methofds

    public String getDeletedAcountMessage()
    {
        return  textDeleteaccount.getText();
    }

    public void clickContinueButton()
    {
        btnContinue.click();
    }


}
