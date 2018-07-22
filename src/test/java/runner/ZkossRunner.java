package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by Karthik on 10/26/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features"} , format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "steps" , tags = {"@rk"})
public class ZkossRunner extends AbstractTestNGCucumberTests{

}
