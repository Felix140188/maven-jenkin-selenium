package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_20_Manage_Data_III extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = UserData.Register.EMAIL_ADDRESS + generationNumber() + "@mail.com";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Choose 'Female' radio button");
		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 03: Input to 'Firstname' textbox with value is: '" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", UserData.Register.FIRST_NAME);

		log.info("Register - Step 04:  Input to 'Lastname' textbox with value is: '" + UserData.Register.LAST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "LastName", UserData.Register.LAST_NAME);

		log.info("Register - Step 05:  Select 'Date Of Birth' with value is: '" + UserData.Register.DAY + UserData.Register.MONTH + UserData.Register.YEAR + "'");
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthDay", UserData.Register.DAY);
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);
		registerPage.selectDropdownOptionByName(driver, "DateOfBirthYear", UserData.Register.YEAR);

		log.info("Register - Step 06:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 07:  Check to 'Newsletter' checkbox");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 08:  Input to 'Password' textbox with value is: '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

		log.info("Register - Step 09:  Input to 'Confirm Password' textbox with value is: '" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", UserData.Register.PASSWORD);

		log.info("Register - Step 10: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 11: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		homePage = registerPage.clickToContinueButton();
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03:  Input to 'Password' textbox with value is: '" + UserData.Register.PASSWORD + "'");
		loginPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

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

	@Test
	public void User_03_My_Account() {
		log.info("MyAccount - Step 01: Navigate to 'Customer Info' page");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("My_Account - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("My_Account - Step 03: Verify registered 'First Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), UserData.Register.FIRST_NAME);

		log.info("My_Account - Step 04: Verify registered 'Last Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), UserData.Register.LAST_NAME);

		log.info("My_Account - Step 05: Verify registered 'Email' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
