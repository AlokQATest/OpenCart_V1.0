package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super (driver);
	}
	
	//Locator
	@FindBy(xpath = "//h1[normalize-space()='My Account']") WebElement confirmation_msg;
//	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement link_myacc;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement link_logout;
	
	//Action method
	
	public boolean confirm_msg() {
		
		return confirmation_msg.isDisplayed();
	
	}
	
//	public void clickMyacc() {
//		link_myacc.click();
//	}
	
	public void clickLogout() {
		link_logout.click();
	}
	
}
