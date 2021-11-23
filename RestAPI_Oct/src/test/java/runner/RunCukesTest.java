package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\java\\features\\CreateCR.feature", glue = "stepdefn")

public class RunCukesTest extends AbstractTestNGCucumberTests {
	
	

}
