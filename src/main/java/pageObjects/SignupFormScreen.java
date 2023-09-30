package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ElementsUtilities;

public class SignupFormScreen
{
    public WebDriver driver;
    private ElementsUtilities elementsUtilities;
    public SignupFormScreen(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        elementsUtilities = new ElementsUtilities(driver);
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
        return elementsUtilities.getTextsOfElement(centerTextsonScreen);
    }

    public void clickMrRadioButton()
    {
       elementsUtilities.elementClick(genderRadiobutton);
    }

    public void setPassword(String password)
    {
        elementsUtilities.elementSendKeys(textFieldPassword,password);
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
        elementsUtilities.elementClick(checkBoxNewsLetter);
    }

    public void clikSpecialOffers()
    {
        elementsUtilities.elementClick(checkBoxSpecialOffers);
    }

    public void setFirstName(String firstName)
    {
        elementsUtilities.elementSendKeys(textFieldFirstName,firstName);
    }

    public void setLastName(String lastName)
    {
       elementsUtilities.elementSendKeys(textFieldLastName,lastName);
    }

    public void setCompany(String company)
    {
      elementsUtilities.elementSendKeys(textFieldCompany,company);
    }

    public void setTextFieldAddress1(String address1)
    {
        elementsUtilities.elementSendKeys(textFieldAddress1,address1);
    }

    public void setTextFieldAddress2(String address2)
    {
       elementsUtilities.elementSendKeys(textFieldAddress2,address2);
    }

    public void selectCountry(String country)
    {
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }

    public void setState(String state)
    {
       elementsUtilities.elementSendKeys(textFieldState,state);
    }

    public void setZipcode(String zipcode)
    {
        elementsUtilities.elementSendKeys(textFieldZipcode,zipcode);
    }

    public void setMobileNUmber(String mobileNUmber)
    {
        elementsUtilities.elementSendKeys(textFieldMobileNUmber,mobileNUmber);
    }

    public void clickOnSubmitForm()
    {
        elementsUtilities.elementClick(buttonSubmitForm);
    }
    public void setTextFieldCity(String city)
    {
        elementsUtilities.elementSendKeys(textFieldCity,city);
    }

}
