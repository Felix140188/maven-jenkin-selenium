package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_C extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-condition - Step 02:  Set cookie and reload page ");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : Common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookies at C class: " + cookie);
		}
		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());
	}
	
	@Test
	public void Search_01_Empty_Data() {
		
	}
	
	@Test
	public void Search_02_Relative_Product_Name() {
		
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}
	
	@Test
	public void Search_04_Parent_Category() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
