package CucumberPractice;

import hook.Hooks;
import io.cucumber.java.en.Given;

public class Test2 {

	@Given("Test for UPI")
	public void test_for_upi() {
	    System.out.println("Test for report");
	    Hooks.getScenario().log("Test for report");
	}
}
