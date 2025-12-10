package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	FileInputStream file;
	public Properties prop;
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		file = new FileInputStream("./src/test/resources/config.properties");
		//or
		// FileReader = new FileReader("./src/test/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		
		
		System.out.println("Starting point");
		logger = LogManager.getLogger(this.getClass());
		switch(br) {
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser"); return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		System.out.println("Ending point");
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
