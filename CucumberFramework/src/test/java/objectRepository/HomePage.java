package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hook.Hooks;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "search")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[name()='svg' and @id='searchBtn']")
	private WebElement searchButton;
	
	public String itemPage = "//div[contains(@class,'breadCrumb')]//a[normalize-space()='ITEMNAME']";
	
	public void searchForItem(String itemName) {
		searchBox.sendKeys(itemName);
		searchButton.click();
		Hooks.getScenario().log("Searched fot item : " + itemName);
	}
	public boolean isItemPageDisplayed(String itemName) {
		boolean pageDisplayed = driver.findElement(By.xpath(itemPage.replace("ITEMNAME",itemName))).isDisplayed();
		return pageDisplayed;
	}
	
}
