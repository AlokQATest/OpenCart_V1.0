package testCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	public FileInputStream file;
	public Properties prop;
	
	@Test
	public void login_Test() {
		try {
			file = new FileInputStream("./src/test/resources/config.properties");
			prop = new Properties();
			prop.load(file);
			
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
		
			hp.clickLogin();
			logger.info("Clicked on Login link");
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			logger.info("Providing login credentials");
			
			lp.provide_Email(prop.getProperty("email"));
			lp.provide_Pass(prop.getProperty("password"));
			lp.click_submit();
			logger.info("Clicked on Login");
			
			//MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			
			boolean msg = map.confirm_msg();
			logger.info("Validating successful login");
			if(msg==true){
				logger.info("Login was successful");
				Assert.assertTrue(true);
			
			}else {
				logger.info("Login failed");
				Assert.assertTrue(false);
			
			}
			
			
			map.clickLogout();
		}
		catch(Exception e) {
			logger.info("got error");
			Assert.fail();
		}
		
	}
}
