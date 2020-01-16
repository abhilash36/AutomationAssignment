package org.testyantra.com.AmazonAndFlipkart;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testyantra.com.AmazonAndFlipkart.genericlibrary.BaseClass;
import com.task.objectrepository.assignment1.AmazonPage;
import com.task.objectrepository.assignment1.FlipkartPage;

/**
 * 
 * @author Abhilash
 *
 */
public class ComparePriceTest extends BaseClass 
{
	@Test
	public void comparePriceTest() throws Throwable 
	{
		
		/* Navigating to Amazon */
		AmazonPage amazon = new AmazonPage(BaseClass.driver);
		
		/* Search for product */
		amazon.ProductSearch("Sheet1", 1, 0);
		
		/* get the price of a product */
		int amazonPrice = amazon.ProductPrice();
		
		/* navigating to FlipKart */
		FlipkartPage flipkart = new FlipkartPage(BaseClass.driver);
		
		/* Search for product */
		flipkart.ProductSearch("Sheet1", 1, 0);
		
		/* get the price of a product */
		int flipkartPrice = flipkart.ProductPrice();
		
		/* Compare the price from amazon and FlipKart and display it in console */
		if(amazonPrice > flipkartPrice) 
		{
			Reporter.log("Flipkart has Lesser Price than Amazon", true);
			Reporter.log("price of flipkart"+flipkartPrice ,true);
		}
		else if (amazonPrice < flipkartPrice) 
		{
			Reporter.log("Amazon has Lesser Price than flipkart", true);
			Reporter.log("price of amazon"+amazonPrice,true );
		}
		else 
		{
			Reporter.log("Amazon and Flipkart Both have same price", true);
			Reporter.log("price of amazon"+amazonPrice+"price of flipkart"+flipkartPrice ,true);
		}	
  }
}
