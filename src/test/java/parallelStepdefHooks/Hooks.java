package parallelStepdefHooks;
import io.cucumber.java.*;
import logManager.LoggerHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import utilities.PropertyReader;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Hooks
{
    private TestBase testBase;
    private PropertyReader propertyReader;
    public WebDriver driver;
    //private List<String> browsers;
    @Before(order = 0)
    public void launchBrowser() {
        propertyReader= new PropertyReader();
        //String browser = System.getProperty("browser");
        String project_url = propertyReader.getProjectURL();
        String testNGBrowser = propertyReader.getTestNGBrowser();
        //String browser = propertyReader.getBrowser();
        testBase = new TestBase();
        try {
            driver = testBase.webDriverManager(testNGBrowser);
        }catch (IOException e)
        {
            LoggerHelper.logError("weddriver issues "+e.getMessage());
        }
        driver.manage().window().maximize();
        driver.get(project_url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        if (driver != null) {
            driver.quit();
        }
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

    @AfterStep
    public void addScreenShot(Scenario scenario)  {
        if(scenario.isFailed())
        {
            String screenShotName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           // FileHandler.copy(sourcePath, new File("test-output"));
            scenario.attach(sourcePath,"image/png",screenShotName);
        }

    }


}