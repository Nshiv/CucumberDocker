package utilities;

import logManager.LoggerHelper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public synchronized WebDriver webDriverManager(String browser) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String platform = prop.getProperty("remote");
        String hubURL = prop.getProperty("hubURL");
        //String browser = browser_maven != null ? browser_maven:browser_prop;
            if (platform.equalsIgnoreCase("no"))
            {
                if (browser.trim().equalsIgnoreCase("chrome"))
                {
                    String chromeDriverPath = "src/test/resources/testDrivers/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    ChromeOptions options = getChromeOptions();
                    tlDriver.set(new ChromeDriver(options));

                } else if (browser.trim().equalsIgnoreCase("edge"))
                {
                    String edgeDriverPath = "src/test/resources/testDrivers/msedgedriver.exe";
                    System.setProperty("webdriver.edge.driver", edgeDriverPath);
                    EdgeOptions edgeOp = new EdgeOptions();
                    edgeOp.addArguments("--headless");
                    tlDriver.set(new EdgeDriver(edgeOp));
                } else if (browser.trim().equalsIgnoreCase("firefox"))
                {
                    String geckoDriverPath = "src/test/resources/testDrivers/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                    tlDriver.set(new FirefoxDriver());
                }

            } else if(platform.equalsIgnoreCase("yes"))
            {
                if (browser.trim().equalsIgnoreCase("chrome"))
                {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(browser);
                    capabilities.setPlatform(Platform.LINUX);
                    tlDriver.set(new RemoteWebDriver(new URL(hubURL),capabilities));
                }
                if (browser.trim().equalsIgnoreCase("edge"))
                {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(browser);
                    capabilities.setPlatform(Platform.LINUX);
                    tlDriver.set(new RemoteWebDriver(new URL(hubURL),capabilities));
                }
                if (browser.trim().equalsIgnoreCase("firefox"))
                {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(browser);
                    capabilities.setPlatform(Platform.LINUX);
                    tlDriver.set(new RemoteWebDriver(new URL(hubURL),capabilities));
                }
            }
            else {
                LoggerHelper.logError("Error in passing browsers info");
            }
            return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
       return tlDriver.get();
    }

    public static synchronized void quitDriver()
    {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
    private static ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.setBinary("C:\\Users\\ASUS1\\Downloads\\ChromeBrowser\\chrome-win64\\chrome-win64\\chrome.exe");
        options.addArguments("--disable-javascript");
        options.addArguments("ignore-certificate-errors");
        return options;
    }
}
