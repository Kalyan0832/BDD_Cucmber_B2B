package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "./src/test/resources/Features" }, 
				 glue = { "CucumberPractice","hook" }, 
				 plugin = { "pretty",
				"html:reports/LogTest4Parallel.html" }, 
				 monochrome = true, 
				 dryRun = false
				 )
public class RunnerClass extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
