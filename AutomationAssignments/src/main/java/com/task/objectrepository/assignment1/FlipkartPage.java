package com.task.objectrepository.assignment1;

import org.openqa.selenium.Keys;
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

public class FlipkartPage
{
	//Deceleration
	
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeLogin;
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
	private WebElement productPrice;
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	private WebDriver driver;
	
	private CommonLibrary common;
	
	FileLibrary flib = new FileLibrary();
	
	
	//Initialization
	public FlipkartPage(WebDriver driver)  
	{
		driver.get(flib.getPropertyKeyValue("urlFlipkart"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	
	//Utilization
	
	/**
	 * Search for product in FlipKart
	 * @param sheetName,rowNum,celNum
	 */
	public void ProductSearch(String sheetName, int rowNum, int celNum) throws Throwable 
	{
		common.waitForPageToLoad();
		closeLogin.click();
		searchBox.sendKeys(flib.getExcelData(sheetName, rowNum, celNum), Keys.ENTER);
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