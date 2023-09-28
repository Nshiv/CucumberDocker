package cucumberHooks;
import io.cucumber.java.*;
import logManager.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.ContextSetUp;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks
{
    public ContextSetUp contextSetUp;
    private TestBase testBase;
    public Hooks(ContextSetUp  contextSetUp)
    {
        this.contextSetUp=contextSetUp;
    }

    @After(order = 1)
    public void captureAssertions(Scenario scenario)
    {
        Status status= scenario.getStatus();
        System.out.println(status);
    }


    @After(order = 2)
    public void quitBrowser() throws IOException
    {
        testBase= new TestBase();
        testBase.quitDriver();
    }

   /* @After(order = 3)
    public void closeBrowser() throws IOException
    {
        WebDriver driver=contextSetUp.testBase.WebDriverManager();
        if(driver!=null)
        {
            driver.close();
        }
    }*/

    //@AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            WebDriver driver =contextSetUp.testBase.webDriverManager();
            File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] filecontent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(filecontent,"image/png","image");
        }

    }


}