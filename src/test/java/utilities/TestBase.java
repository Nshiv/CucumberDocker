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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String project_url=prop.getProperty("url1");
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven:browser_prop;
        if(driver==null) {
            //URL hubUrl = new URL("http://15.207.88.140:4444/wd/hub");
            if(browser.equalsIgnoreCase("chrome"))
            {
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                options.addArguments("start-maximized"); // Maximize browser window
                options.addArguments("disable-infobars"); // Disable infobars
                options.setBinary("C:\\Users\\ASUS1\\Downloads\\ChromeBrowser\\chrome-win64\\chrome-win64\\chrome.exe");
                options.addExtensions(new File("./extensions/AdBlock5.9.0.0.crx"));
                options.addArguments("--disable-javascript");
                options.addArguments("ignore-certificate-errors");
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                //driver = new RemoteWebDriver(hubUrl,options);
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(project_url);
            }
           else if(browser.equalsIgnoreCase("edge"))
            {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setAcceptInsecureCerts(true);
                driver= new EdgeDriver();
                driver.get(project_url);
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                //driver = new RemoteWebDriver(hubUrl,edgeOptions);
            }
           else {
                System.out.println("Invalid browser inputs"+browser);
            }

            //driver.get(project_url);
        }
        return driver;
    }
}
