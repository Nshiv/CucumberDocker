package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpSuccessScreen
{
    public WebDriver driver;
    public SignUpSuccessScreen(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // elements
    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement signUpSuccessmessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement btnContinue;

    //methods

    public String getSignUpSucesstexts()
    {
        return signUpSuccessmessage.getText();
    }

    public void clickContinuebutton()
    {
        btnContinue.click();
    }

}
