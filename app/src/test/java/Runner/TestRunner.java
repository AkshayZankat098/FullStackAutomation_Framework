package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",                   // ✅ Path to feature a file
        glue = {"StepDefinitionFile"},                              // ✅ Step definition package
        plugin = {"pretty", "html:target/cucumber-report.html"},    // ✅ Optional report
        monochrome = true                                           // ✅ Cleaner console output
)

public class TestRunner extends AbstractTestNGCucumberTests {

}

