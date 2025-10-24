package CucumberPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hook.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.LoginPage;

public class LoginTest {
	WebDriver driver = Hooks.getDriver();
	
	LoginPage lp= new LoginPage(driver);
	
	@Given("Launch browser and enter url")
	public void launch_browser_and_enter_url() {
		
	   driver.get("https://shoppersstack.com/user-signin");
	}

	@Given("login page is displayed")
	public void login_page_is_displayed() {
		 String actualTitle = "ShoppersStack | Login";
		 	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		 	wait.until(ExpectedConditions.titleContains(actualTitle));
		   String expected = driver.getTitle();
		   Assert.assertEquals(actualTitle, expected);
	}

	@When("Enter <UserName> and <password>")
	public void enter_user_name_and_password(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asLists();
	    driver.findElement(By.id("Email")).sendKeys(dataTable.asLists().get(1).get(0));
	    driver.findElement(By.id("Password")).sendKeys(dataTable.asLists().get(1).get(1));
	}

	@When("Click on enter")
	public void click_on_enter() {
		lp.ClickLoginButton();
	   driver.findElement(By.id("Login")).click();
	}

	@Then("User should be logged in")
	public void user_should_be_logged_in() {
	
	}

	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {
		boolean isHomePageDisplayed = driver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed();
		Assert.assertTrue(isHomePageDisplayed,"Home page not displayed");
		driver.quit();
	}

}
