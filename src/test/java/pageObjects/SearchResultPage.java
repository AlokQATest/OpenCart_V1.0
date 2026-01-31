package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
	
	public SearchResultPage(WebDriver driver) {
		super (driver);
	}
	
	//Select product, select variant, select quantity, add to cart, checkout, payment
	
	@FindBy(xpath="//h4") List<WebElement> searched_items;
	@FindBy(xpath = "//button[@data-bs-toggle='dropdown']") WebElement checkout_price;
	
	
	public List<String> product_matches() {
		
		List<WebElement> elements = searched_items;
		List<String> mylist = new ArrayList<>();
		for(WebElement element: elements) {
			mylist.add(element.getText());
		}
		return mylist;
	}
	
	public void add_to_cart(String target_product) {
		
		for(int i=0; i<searched_items.size(); i++ ) {
			String name = searched_items.get(i).getText();
			if(name.equalsIgnoreCase(target_product)) {
				//System.out.println(name +" "+ i);
				driver.findElements(By.xpath("//div[@class='content']//button[1]")).get(i).click();
				break;
			}
			
		}
	}
	
	public boolean check_cart_total(String target_product) {
		boolean price_match = false;
		String product_price = "";
		for(int i=0; i<searched_items.size(); i++ ) {
			String name = searched_items.get(i).getText();
			if(name.equalsIgnoreCase(target_product)) {
				product_price = driver.findElements(By.xpath("//span[@class = 'price-new'][1]")).get(i).getText();
				
				break;
			}
			
		}
			
			if(checkout_price.getText().contains(product_price)) {
				price_match= true;
		}
		
		return price_match;
		
	}
}
