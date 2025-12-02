package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import net.bytebuddy.asm.Advice.This;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		System.out.println("Starting point");
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String randomStr = RandomStringUtils.randomAlphabetic(5);
		return randomStr;
	}
	
	public String randomNum() {
		String randomnum = RandomStringUtils.randomAlphanumeric(8);
		return randomnum;
	}
}
