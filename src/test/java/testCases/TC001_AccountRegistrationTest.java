package testCases;

import org.testng.Assert; 

import org.testng.annotations.Test;

import pageObjects.AccountRegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void verify_account_registration() {
		logger.info("Starting the acc_reg method");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		hp.clickRegister();
		logger.info("Clicked on Register");
		
		AccountRegPage arp = new AccountRegPage(driver);
		logger.info("Filling details");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@yopmail.com");
		arp.setPassword(randomNum());
		arp.setNewsLetter();
		arp.setTermAndCondition();
		arp.continuebtn();
		
		String confirmMsg = arp.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.info("Error");
			logger.debug("Debug");
			Assert.fail();
		}
		logger.info("Test finished");
	
	}
	
	
}
