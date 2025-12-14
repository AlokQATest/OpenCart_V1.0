package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	// Locators
	
	@FindBy(xpath = "//input[@name = 'email']") WebElement input_email;
	@FindBy(xpath = "//input[@name = 'password']") WebElement input_password;
	@FindBy(xpath = "//button[normalize-space() = 'Login']") WebElement submit_login;
	
	
	// Action methods
	
	public void provide_Email(String email) {
		input_email.sendKeys(email);
	}
	
	public void provide_Pass(String password) {
		input_password.sendKeys(password);
	}
	
	public void click_submit() {
		submit_login.click();
	}
	
	
		
	}

