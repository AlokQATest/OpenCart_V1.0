package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void verify_account_registration() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegPage arp = new AccountRegPage(driver);
		
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@yopmail.com");
		arp.setPassword(randomNum());
		arp.setNewsLetter();
		arp.setTermAndCondition();
		arp.continuebtn();
		
		String confirmMsg = arp.getConfirmationMsg();
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	
	}
	
	
}
