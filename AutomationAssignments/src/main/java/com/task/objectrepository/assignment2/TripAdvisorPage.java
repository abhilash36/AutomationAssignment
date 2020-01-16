package com.task.objectrepository.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testyantra.com.AmazonAndFlipkart.genericlibrary.CommonLibrary;
import org.testyantra.com.AmazonAndFlipkart.genericlibrary.FileLibrary;

/**
 * 
 * @author Abhilash
 *
 */
  public class TripAdvisorPage
   {
	private WebDriver driver;
	private CommonLibrary common;
	FileLibrary flib = new FileLibrary();
	
	//Deceleration
	@FindBy(xpath= "//div[@title='Search']") 
	private WebElement searchBox1;
	@FindBy(xpath = "//input[@id='mainSearch']")
	private WebElement searchTxtBx;
	@FindBy(id = "SEARCH_BUTTON_CONTENT")
	private WebElement searchBtn1;
	@FindBy(xpath= "//input[@title='Search']")
	private WebElement searchBox2;
	@FindBy(xpath = "//div[@class='result-title']/span")
	private WebElement textResult;
	@FindBy(xpath = "//a[text()='Write a review']")
	private WebElement reviewscrl;
	@FindBy(id = "ReviewTitle")
	private WebElement ReviewTitle;
	@FindBy(id = "ReviewText")
	private WebElement ReviewText;
	@FindBy(xpath = "//div[text()='Hotel Ratings']")
	private WebElement ratingScroll;
	@FindBy(id = "SUBMIT")
	private WebElement submitBtn;
	
	
	//Initializing
		public TripAdvisorPage(WebDriver driver)
		{	
			this.driver = driver;
			driver.get(flib.getPropertyKeyValue("urlTripAdvisor"));
			PageFactory.initElements(driver, this);
			common = new CommonLibrary(driver);
		}
		
		
		
		
	//Utilization
		
		/**
		 * Search for ClubMahindra in TripAdvisor
		 * @param driver,sheetName,rowNum,celNum
		 */
	public void searchInTripAdvisor(WebDriver driver,String sheetName, int rowNum, int celNum) throws Throwable 
	{
		try 
		{
			searchBox1.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(searchTxtBx));
			searchTxtBx.sendKeys(flib.getExcelData(sheetName, rowNum, celNum));
			searchBtn1.click();
		}
		
		catch(Exception e) 
		{
			searchBox2.sendKeys(flib.getExcelData(sheetName, rowNum, celNum));
			
		}
	}
	
	
	
	/**
	 * Search for reviewTitleTripAdvisor in TripAdvisor
	 * @param driver,sheetName,rowNum,celNum
	 */
	public void reviewTitleTripAdvisor(WebDriver driver,String sheetName, int rowNum, int celNum) throws Throwable 
	 {
		textResult.click();
		common.switchToChildWindow();
		Actions act = new Actions(driver);
		act.moveToElement(reviewscrl).perform();
		reviewscrl.click();
		common.switchWindow(driver, "Write a review");
		ReviewTitle.sendKeys(flib.getExcelData(sheetName, rowNum, celNum));
	}
	
	
	
	/**
	 * Search for  reviewTextTripAdvisor in TripAdvisor
	 * @param sheetName,rowNum,celNum
	 */
	public void reviewTextTripAdvisor(String sheetName, int rowNum, int celNum) throws Throwable 
	{
		ReviewText.sendKeys(flib.getExcelData(sheetName, rowNum, celNum));
		common.scroll(driver,ratingScroll);
		common.scroll(driver, submitBtn);
		submitBtn.click();
	}
 }
	
