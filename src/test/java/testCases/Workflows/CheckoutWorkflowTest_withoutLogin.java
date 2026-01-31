package testCases.Workflows;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class CheckoutWorkflowTest_withoutLogin extends BaseClass{
	
	@Test (groups = {"Master"})
	public void checkout_complete_flow() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.search_products("Macbook");
		
		SearchResultPage srp = new SearchResultPage(driver);
		List<String> actual_product_list = srp.product_matches();
		
		List<String> expected_product_list = Arrays.asList(
				"MacBook",
				"MacBook Air",
				"MacBook Pro"
				
				);
		
		//Matching product from search page with expected products
		Assert.assertEquals(actual_product_list, expected_product_list, "Products are not matching");
		System.out.println("products are matched");
		
		//Adding product to cart
		srp.add_to_cart("Macbook pro");
		
		//Checking Cart total with product price
		Assert.assertTrue(srp.check_cart_total("Macbook pro"), "Price did not match");
		System.out.println("price matched");
		
				
	}
}
