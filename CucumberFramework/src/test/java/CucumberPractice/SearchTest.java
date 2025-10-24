package CucumberPractice;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hook.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.HomePage;

public class SearchTest {

	WebDriver driver = Hooks.getDriver();
	HomePage hp = new HomePage(driver);
	String itemName;
	
	@When("Search for products {string}")
	public void search_for_products(String item) {
	    hp.searchForItem(item);
	    itemName= item;
	}

	@Then("Page should be displayed")
	public void page_should_be_displayed() {
	    Assert.assertTrue(hp.isItemPageDisplayed(itemName));
	}
}
