package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException
    {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String project_url=prop.getProperty("url1");
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven:browser_prop;
        if(driver==null) {
            URL hubUrl = new URL("http://localhost:4444/wd/hub");
            if(browser.equalsIgnoreCase("chrome"))
            {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(hubUrl,options);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
           else if(browser.equalsIgnoreCase("edge"))
            {
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(hubUrl,edgeOptions);
            }
           else {
                System.out.println("Invalid browser inputs"+browser);
            }

            driver.get(project_url);
        }
        return driver;
    }
}
