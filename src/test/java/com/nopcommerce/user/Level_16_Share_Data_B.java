package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_16_Share_Data_B extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "test" + generationNumber() + "@mail.com";
		password = "123456";
		
		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-condition - Step 02: Input to 'Firstname' textbox with value is: '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Pre-condition - Step 03:  Input to 'Lastname' textbox with value is: '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - Step 04:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05:  Input to 'Password' textbox with value is: '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 06:  Input to 'Confirm Password' textbox with value is: '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre-condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-condition - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Pre-condition - Step 09: Click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Pre-condition - Step 10: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-condition - Step 11:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 12:  Input to 'Password' textbox with value is: '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 13: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
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
