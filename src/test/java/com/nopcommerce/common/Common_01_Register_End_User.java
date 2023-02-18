package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new common user for all Classes Test")
	public void Register(String browserName) {
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
		
		driver.quit();
	}
}
