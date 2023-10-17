package parallelStepdefHooks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.PropertyReader;

@CucumberOptions(
        glue = {"parallelStepdefHooks"},
        features = "src/test/resources/parallel",
        monochrome = true,
        tags="@new ",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt",
        "timeline:test-output-thread/",
       }
)

public class TestParallel extends AbstractTestNGCucumberTests
{
      @Override
       @DataProvider(parallel = true)
       public Object[][] scenarios()
       {
          return super.scenarios();
       }

    /*@BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
           PropertyReader propertyReader = new PropertyReader();
           propertyReader.setTestNGBrowser(browser);

    }*/
}
