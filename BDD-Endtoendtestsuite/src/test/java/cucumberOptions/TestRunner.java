package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", ///Users/agileengine/Projects/Automation/src/test/java/features
        glue = "stepDefinations") //src/test/stepDefinations/stepDefinition.java

public class TestRunner extends AbstractTestNGCucumberTests {

}
