package utilities;
import org.openqa.selenium.WebDriver;
import pageObjManager.PageObjectManager;

import java.io.IOException;

public class ContextSetUp
{
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public ElementsUtilities elementsUtilities;

    public ContextSetUp() throws IOException
    {
        this.testBase = new TestBase();
        this.pageObjectManager=new PageObjectManager(testBase.webDriverManager());
        this.genericUtils = new GenericUtils(testBase.webDriverManager());
        this.elementsUtilities = new ElementsUtilities(testBase.webDriverManager());

    }
}