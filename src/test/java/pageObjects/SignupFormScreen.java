package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupFormScreen
{
    public WebDriver driver;
    public SignupFormScreen(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    //locators

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement centerTextsonScreen;

    @FindBy(xpath = "//input[@value='Mr']")
    private WebElement genderRadiobutton;

    @FindBy(id = "name")
    private WebElement textFieldName;

    @FindBy(id="email")
    private WebElement textFieldEmail;

    @FindBy(id = "password")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement selectDays;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement selectyears;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement checkBoxNewsLetter;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement checkBoxSpecialOffers;

    @FindBy(id = "first_name")
    private WebElement textFieldFirstName;

    @FindBy(id="last_name")
    private WebElement textFieldLastName;

    @FindBy(id="company")
    private WebElement textFieldCompany;

    @FindBy(id="address1")
    private WebElement textFieldAddress1;

    @FindBy(id="address2")
    private WebElement textFieldAddress2;

    @FindBy(xpath="//select[@id=\"country\"]")
    private WebElement selectCountry;

    @FindBy(id="state")
    private WebElement textFieldState;

    @FindBy(id="city")
    private WebElement textFieldCity;

    @FindBy(id="zipcode")
    private WebElement textFieldZipcode;

    @FindBy(id="mobile_number")
    private WebElement textFieldMobileNUmber;

    @FindBy(xpath = "//button[text()=\"Create Account\"]")
    private  WebElement buttonSubmitForm;


    //methods

    public String getPageTitle()
    {
        return  driver.getTitle();
    }

    public String getSignupTexts()
    {
        return centerTextsonScreen.getText();
    }

    public void clickMrRadioButton()
    {
        genderRadiobutton.click();
    }

    public void setPassword(String password)
    {
        textFieldPassword.sendKeys(password);
    }

    public void setDaysInDOB(String dateOfBirth)
    {
        String[] dob = dateOfBirth.split("/");
        Select select = new Select(selectDays);
        select.selectByValue(dob[0]);
    }

    public void setMonthInDOB(String dateOfBirth)
    {
        String[] dob = dateOfBirth.split("/");
        Select select = new Select(selectMonth);
        select.selectByVisibleText(dob[1]);
    }

    public void setYearInDOB(String dateOfBirth)
    {
        String[] dob = dateOfBirth.split("/");
        Select select = new Select(selectyears);
        select.selectByValue(dob[2]);
    }

    public void clickNewsletter()
    {
        checkBoxNewsLetter.click();
    }

    public void clikSpecialOffers()
    {
        checkBoxSpecialOffers.click();
    }

    public void setFirstName(String firstName)
    {
        textFieldFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName)
    {
        textFieldLastName.sendKeys(lastName);
    }

    public void setCompany(String company)
    {
        textFieldCompany.sendKeys(company);
    }

    public void setTextFieldAddress1(String address1)
    {
        textFieldAddress1.sendKeys(address1);
    }

    public void setTextFieldAddress2(String address2)
    {
        textFieldAddress2.sendKeys(address2);
    }

    public void selectCountry(String country)
    {
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }

    public void setState(String state)
    {
        textFieldState.sendKeys(state);
    }

    public void setZipcode(String zipcode)
    {
        textFieldZipcode.sendKeys(zipcode);
    }

    public void setMobileNUmber(String mobileNUmber)
    {
        textFieldMobileNUmber.sendKeys(mobileNUmber);
    }

    public void clickOnSubmitForm()
    {
        buttonSubmitForm.click();
    }
    public void setTextFieldCity(String city)
    {
        textFieldCity.sendKeys(city);
    }

}
