package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass{
	
	@Test (dataProvider="logindata", dataProviderClass=DataProviders.class, groups="DataDriven") //getting data provider from different package
	public void testLogin(String email, String pass, String expResult) {
		try {	
			
		logger.info("Starting DDT");	
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.provide_Email(email);
		lp.provide_Pass(pass);
		lp.click_submit();
		
		MyAccountPage map= new MyAccountPage(driver);
		boolean targetPage = map.confirm_msg();
		System.out.println(map.confirm_msg());
		
		if(expResult.equals("Valid")) {
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
		}
		if(expResult.equals("Invalid")){
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			//Assert.fail();
		}
	}
}
