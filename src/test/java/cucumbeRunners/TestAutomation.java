package cucumbeRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepDefinitions","cucumberHooks"},
        features = "src/test/java/features",
        monochrome = true,
        tags="@wip"
       // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"}
)

public class TestAutomation extends AbstractTestNGCucumberTests
{


}
