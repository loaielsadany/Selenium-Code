package Runner;

import Test.TestBase;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (features = "src/test/java/features",glue={"Steps"},
        plugin={"pretty","html:test-output/Cucumber-report"})

public class TestRunner extends TestBase {


}
