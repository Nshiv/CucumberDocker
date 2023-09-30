package parallelStepdefHooks;
import io.cucumber.java.*;
import logManager.LoggerHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks
{
    private TestBase testBase;
    private Properties properties;
    public WebDriver driver;
    @Before(order = 0)
    public void launchBrowser() {
        String browser_prop = null;
        String project_url = null;
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            properties = new Properties();
            properties.load(fis);
            testBase = new TestBase();
            project_url = properties.getProperty("url");
            browser_prop = properties.getProperty("browser");
        } catch (IOException e) {
            LoggerHelper.logError("Error in reading and fetching properties file values   >>" + e.getMessage());
        }
        try {
            this.driver = testBase.webDriverManager(browser_prop);
        } catch (WebDriverException | IOException e) {
            LoggerHelper.logException("launch browser exceptions" + e.getMessage(),e);
        }

        //driver.manage().window().maximize();
        this.driver.get(project_url);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        if (this.driver != null) {
            this.driver.quit();
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