package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends BasePage{

	public AccountRegPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	
	@FindBy(xpath = "//input[@name='firstname']") WebElement firstname;
	@FindBy(xpath = "//input[@name='lastname']") WebElement lastname;
	@FindBy(xpath = "//input[@name='email']") WebElement email;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//input[@id='input-newsletter']") WebElement newsletter;
	@FindBy(xpath = "//input[@name='agree']") WebElement agreeTandC;
	@FindBy(xpath = "//button[normalize-space()='Continue']") WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space() = 'Your Account Has Been Created!']") WebElement msgconfirmation;
	
	// Action methods
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void setNewsLetter() {
		newsletter.click();
	}
	
	public void setTermAndCondition() {
		agreeTandC.click();
	}
	
	public void continuebtn() {
		btncontinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgconfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
