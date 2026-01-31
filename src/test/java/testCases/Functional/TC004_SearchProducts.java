package testCases.Functional;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC004_SearchProducts extends BaseClass {
	
	@Test (groups = {"E-to-E", "Master"})
	public void search_product() throws InterruptedException {
		
		HomePage hp =new HomePage(driver);
	
		hp.search_products("Macbook");
		Thread.sleep(5);
		SearchResultPage srp = new SearchResultPage(driver);
		List<String> srp_items = srp.product_matches();
		
		List<String> expected_items = Arrays.asList(
				"MacBook",
				"MacBook Air",
				"MacBook Pro"
				);
		Thread.sleep(5);
		
		//Check whether search results matches with expected result
		Assert.assertEquals(srp_items, expected_items, "Search Results do not match");
	}
}
