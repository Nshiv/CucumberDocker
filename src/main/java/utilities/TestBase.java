package utilities;

import logManager.LoggerHelper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver webDriverManager(String browser) throws IOException {
        String platform = PropertyReader.getPlateform();
        String hubURL = PropertyReader.getHubURL();

        WebDriver driver;

        if (platform.equalsIgnoreCase("no")) {
            driver = createLocalDriver(browser);
        } else if (platform.equalsIgnoreCase("yes")) {
            driver = createRemoteDriver(browser, hubURL);
        } else {
            throw new IllegalArgumentException("Invalid platform specified.");
        }

        // Store the driver instance in ThreadLocal
        tlDriver.set(driver);

        return driver;
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }

    private WebDriver createLocalDriver(String browser)
    {
        System.out.println("In test base class"+browser);
        WebDriver driver;
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                String chromeDriverPath = "src/test/resources/testDrivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                String edgeDriverPath = "src/test/resources/testDrivers/msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                String geckoDriverPath = "src/test/resources/testDrivers/geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                //firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified.");
        }
        return driver;
    }

    private WebDriver createRemoteDriver(String browser, String hubURL) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        try {
            return new RemoteWebDriver(new URL(hubURL), capabilities);
        } catch (MalformedURLException e) {

            throw new RuntimeException("Failed to create a RemoteWebDriver instance.", e);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.setBinary("C:\\Users\\ASUS1\\Downloads\\ChromeBrowser\\chrome-win64\\chrome-win64\\chrome.exe");
        options.addArguments("--disable-javascript");
        options.addArguments("ignore-certificate-errors");
        return options;
    }
}
