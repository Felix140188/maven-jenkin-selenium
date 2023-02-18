package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapping;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.Environment;

public class Level_22_Multiple_Environment_Owner extends BaseTest {
	private WebDriver driver;
	private UserDataMapping userData;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private Environment environment;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String environmentName = System.getProperty("environment");
		
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		
		driver = getBrowserDriver(browserName, environment.appUrl());
		System.out.println(environment.appUsername());
		System.out.println(environment.appPassword());
		System.out.println(environment.dbHostname());
		System.out.println(environment.dbUsername());
		System.out.println(environment.dbPassword());

		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapping.getUserData();

		emailAddress = userData.getEmailAddress() + generationNumber() + "@mail.com";
	}

	@Description("Register to system")
	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Choose 'Female' radio button");
		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 03: Input to 'Firstname' textbox with value is: '" + userData.getFirstName() + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 04:  Input to 'Lastname' textbox with value is: '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register - Step 05:  Select 'Date Of Birth' with value is: '" + userData.getDay() + userData.getMonth() + userData.getYear() + "'");
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthDay", userData.getDay());
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 06:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 07:  Check to 'Newsletter' checkbox");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 08:  Input to 'Password' textbox with value is: '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register - Step 09:  Input to 'Confirm Password' textbox with value is: '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register - Step 10: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 11: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Description("Login to system")
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		homePage = registerPage.clickToContinueButton();
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03:  Input to 'Password' textbox with value is: '" + userData.getPassword() + "'");
		loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Login - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

		log.info("Login - Step 06: Navigate to 'Customer Info' page");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 07: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Description("User_03_My_Account")
	@Test
	public void User_03_My_Account() {
		log.info("MyAccount - Step 01: Navigate to 'Customer Info' page");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("My_Account - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("My_Account - Step 03: Verify registered 'First Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());

		log.info("My_Account - Step 04: Verify registered 'Last Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("My_Account - Step 05: Verify registered 'Email' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
