package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hook.Hooks;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "Login")
	private WebElement login_Button;
	
	public void ClickLoginButton() {
		login_Button.click();
		Hooks.getScenario().log("Clicked on login button");
	}
}
