package com.task.objectrepository.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testyantra.com.AmazonAndFlipkart.genericlibrary.CommonLibrary;
import org.testyantra.com.AmazonAndFlipkart.genericlibrary.FileLibrary;

/**
 * 
 * @author Abhilash
 *
 */

public class AmazonPage
{
	//Deceleration
	private WebDriver driver;
	private CommonLibrary common;
	
	FileLibrary flib = new FileLibrary();
	
	@FindBy(id = "twotabsearchtextbox") 
	private WebElement searchBox;
	
	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../..//span[@class='a-price-whole']")
	private WebElement productPrice;
	
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchBtn;
	
	
	//Initialization
	public AmazonPage(WebDriver driver) 
	{
		driver.get(flib.getPropertyKeyValue("urlAmazon"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	
	
	//Utilization
	
	/**
	 * Search for product in Amazon
	 * @param sheetName,rowNum,celNum
	 */
	public void ProductSearch(String sheetName, int rowNum, int celNum) throws Throwable 
	{
		common.waitForPageToLoad();
		searchBox.sendKeys(flib.getExcelData(sheetName, rowNum, celNum));
		searchBtn.click();
	}
	
	
	/**
	 *Check for price of the respective product
	 */
	public int ProductPrice() throws Throwable 
	{
		common.waitForPageToLoad();
		common.waitForElemnetToAppear(productPrice);
		String data = productPrice.getText();
		int productPrice = common.removeSpecialChars(data);
		return productPrice;
	}
}
