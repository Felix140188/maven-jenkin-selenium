package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFiles.HomePageObject;
import pageObject.jQuery.uploadFiles.PageGeneratorManager;

public class Level_11_UploadFile extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	String coffeeFileName = "coffee.jpg";
	String blendedCoffeeFileName = "blended-coffee.jpg";
	String milkCoffeeFileName = "milk-coffee.jpg";
	String strawberryFileName = "strawberry.jpg";
	String[] allFileNames = {coffeeFileName, blendedCoffeeFileName, milkCoffeeFileName, strawberryFileName};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Upload_01_Single_File() {
		homePage.uploadMultipleFiles(driver, coffeeFileName);
		Assert.assertTrue(homePage.isFileNameLoaded(coffeeFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileNameUploaded(coffeeFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(coffeeFileName));
	}
	
	@Test
	public void Upload_02_Multiple_Files() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, allFileNames);
		Assert.assertTrue(homePage.isFileNameLoaded(coffeeFileName));
		Assert.assertTrue(homePage.isFileNameLoaded(blendedCoffeeFileName));
		Assert.assertTrue(homePage.isFileNameLoaded(milkCoffeeFileName));
		Assert.assertTrue(homePage.isFileNameLoaded(strawberryFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileNameUploaded(coffeeFileName));
		Assert.assertTrue(homePage.isFileNameUploaded(blendedCoffeeFileName));
		Assert.assertTrue(homePage.isFileNameUploaded(milkCoffeeFileName));
		Assert.assertTrue(homePage.isFileNameUploaded(strawberryFileName));
		
		Assert.assertTrue(homePage.isFileImageUploaded(coffeeFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(blendedCoffeeFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(milkCoffeeFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(strawberryFileName));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
