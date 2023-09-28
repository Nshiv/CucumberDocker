package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public synchronized WebDriver webDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String platform = prop.getProperty("remote");
        String hubURL = prop.getProperty("hubURL");
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven:browser_prop;
        String project_url = prop.getProperty("url");
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
                    tlDriver.set(new EdgeDriver());
                } else if (browser.trim().equalsIgnoreCase("firefox"))
                {
                    String geckoDriverPath = "src/test/resources/testDrivers/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                    tlDriver.set(new FirefoxDriver());
                }

                if(!(getDriver()==null))
                {
                    getDriver().manage().window().maximize();
                    getDriver().get(project_url);
                    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
            }return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
       return tlDriver.get();
    }

    public  synchronized void quitDriver()
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
