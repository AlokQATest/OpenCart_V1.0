package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	// Locators
	
	@FindBy(xpath = "//span[normalize-space()= 'My Account']") WebElement linkMyaccount;
	@FindBy(xpath = "//a[normalize-space() = 'Register']") WebElement linkRegister;
	@FindBy(xpath = "//a[normalize-space() = 'Login']") WebElement linkLogin;
	
	// Search product locator
	@FindBy(xpath = "//input[@name='search']") WebElement search_bar;
	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']") WebElement submit;
	
	
	// Action methods
	
	public void clickMyAccount() {
		linkMyaccount.click();
	}
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	//search product method
	public void search_products(String product_name) {
		search_bar.sendKeys(product_name);
		submit.click();
	}
	
}
