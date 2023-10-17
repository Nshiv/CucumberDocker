package parallelStepdefHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logManager.LoggerHelper;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import utilities.ContextSetUp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinksCountStepDef
{
    public ContextSetUp contextSetUp;
    public HomePage homePage;

    public LinksCountStepDef(ContextSetUp contextSetUp)
    {
        this.contextSetUp= contextSetUp;
        homePage= contextSetUp.pageObjectManager.getHomePage();
    }

    @And("I log all the links present on Homepage screen")
    public void getLinksCountOnHomePage()
    {
        LoggerHelper.logInfo("Total Number of links on homepage are "+homePage.gelLinksCount());
    }

    @And("I print all the links in Logger file")
    public void printAllLinks()
    {
        Set<WebElement> allLinks = new HashSet<WebElement>(homePage.getAllLinks());

        for(WebElement pageLink : allLinks)
        {
            String href = pageLink.getAttribute("href");
            if(href!=null && !href.isEmpty())
            {
               LoggerHelper.logInfo(href);
            }
        }
    }

    @And("I log all broken links on webpage")
    public void getAllBrokenLinks() throws IOException {
        Set<WebElement> allLinks = new HashSet<>(homePage.getAllLinks());
        for (WebElement links : allLinks)
        {
            String href = links.getAttribute("href");
                if(href!=null && !href.isEmpty())
                {
                    HttpURLConnection connection= null;
                    try {
                    URL url = new URL(href);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        LoggerHelper.logError("broken links is >> " + url + " Response code is " + responseCode);
                    }
                }catch (Exception e)
                    {
                        LoggerHelper.logError("Error while getting response code of link "+href+"  "+ e.getMessage());
                    }
                    finally {
                        if (connection != null
                        ) {
                            connection.disconnect();
                        }
                    }
            }

        }
    }
}
