package hook;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	static ThreadLocal<WebDriver> driverValue = new ThreadLocal<WebDriver>();
	static ThreadLocal<Scenario> scenarioRunning = new ThreadLocal<Scenario>();
	WebDriver driver;

	public void setDriver(WebDriver driver) {
		driverValue.set(driver);
	}

	public static WebDriver getDriver() {
		return driverValue.get();
	}
	
	public void setScenario(Scenario scenario) {
		scenarioRunning.set(scenario);
	}
	
	public static Scenario getScenario() {
		return scenarioRunning.get();
	}

	@Before
	public void beforeAll(Scenario scenario) {
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		setScenario(scenario);
		getScenario().log("Before scenario");
	}

	@BeforeAll
	public static void before_all() {
		
	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {
		
		scenario.log("Before step started");
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.log(scenario.getName() + " : Failed");
			TakesScreenshot ts = (TakesScreenshot) getDriver();
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

	}

	@AfterAll
	public static void after_all() {
		Reporter.log("After all executed");
	}

	@After
	public void afterAll() {
		getScenario().log(getScenario().getName() + " : Scenario execution ended");
		getDriver().quit();
	}
}
