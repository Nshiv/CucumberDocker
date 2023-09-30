package parallelStepdefHooks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"parallelStepdefHooks"},
        features = "@target/failed_scenarios.txt",
        monochrome = true,
        tags="@wip",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt",
                "timeline:test-output-thread/",
        }
)

public class FailedScenariosRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
