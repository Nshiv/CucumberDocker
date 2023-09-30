package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ElementsUtilities;

public class SignUpSuccessScreen
{
    public WebDriver driver;
    private ElementsUtilities elementsUtilities;
    public SignUpSuccessScreen(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementsUtilities= new ElementsUtilities(driver);
    }

    // elements
    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement signUpSuccessmessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement btnContinue;

    //methods

    public String getSignUpSucesstexts()
    {
        return elementsUtilities.getTextsOfElement(signUpSuccessmessage);
    }

    public void clickContinuebutton()
    {
       elementsUtilities.elementClick(btnContinue);
    }

}
