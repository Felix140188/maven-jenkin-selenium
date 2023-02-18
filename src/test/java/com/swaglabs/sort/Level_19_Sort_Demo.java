package com.swaglabs.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.swaglabs.LoginPageObject;
import pageObjects.swaglabs.PageGeneratorManager;
import pageObjects.swaglabs.ProductPageObject;

public class Level_19_Sort_Demo extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	private String userName = "standard_user";
	private String password = "secret_sauce";
	
	@Parameters({ "browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 01: Input to 'Username' field with value: " + userName);
		loginPage.inputToUsernameField(userName);
		
		log.info("Pre-Condition - Step 02: Input to 'Password' field with value: " + password);
		loginPage.inputToPasswordField(password);
		
		log.info("Pre-Condition - Step 03: Click to 'LOGIN' button ");
		productPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void Sort_01_Product_Name_Ascending() {
		log.info("Sort 01 - Step 01: Select option 'Name (A to Z)' in sort dropdown");
		productPage.selectOptionAtSortDropdown("Name (A to Z)");
		
		log.info("Sort 01 - Step 02: verify products are displayed as Ascending order By Name");
		verifyTrue(productPage.isProductNameDisplayedAscendingOrder());
	}
	
//	@Test
	public void Sort_02_Product_Name_Ascending_java8() {
		log.info("Sort Java8 - Step 01: Select option 'Name (A to Z)' in sort dropdown");
		productPage.selectOptionAtSortDropdown("Name (A to Z)");
		
		log.info("Sort Java8 - Step 02: verify products are displayed as Ascending order By Name");
		verifyTrue(productPage.isDataSortAscendingOrder());
	}
	
	@Test
	public void Sort_03_Product_Name_Descending() {
		log.info("Sort 03 - Step 01: Select option 'Name (Z to A)' in sort dropdown");
		productPage.selectOptionAtSortDropdown("Name (Z to A)");
		
		log.info("Sort 03 - Step 02: verify products are displayed as Descending order By Name");
		verifyTrue(productPage.isProductNameDisplayedDescendingOrder());
	}
	
	@Test
	public void Sort_04_Product_Price_Ascending() {
		log.info("Sort 04 - Step 01: Select option 'Price (low to high)' in sort dropdown");
		productPage.selectOptionAtSortDropdown("Price (low to high)");
		
		log.info("Sort 04 - Step 02: verify products are displayed as Ascending order By Price");
		verifyTrue(productPage.isProductPriceDisplayedAscendingOrder());
	}
	
	@Test
	public void Sort_05_Product_Price_Descending() {
		log.info("Sort 05 - Step 01: Select option 'Price (high to low)' in sort dropdown");
		productPage.selectOptionAtSortDropdown("Price (high to low)");
		
		log.info("Sort 05 - Step 02: verify products are displayed as Ascending order By Price");
		verifyTrue(productPage.isProductPriceDisplayedDescendingOrder());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
