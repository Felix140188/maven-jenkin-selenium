//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManager;
//
//public class Level_15_ExtentV2_Screenshot2 extends BaseTest {
//	private WebDriver driver;
//	private String firstName, lastName, emailAddress, password;
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInfoPageObject customerInfoPage;
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		
//		firstName = "Automation";
//		lastName = "Testing";
//		emailAddress = "test" + generationNumber() + "@mail.com";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Input to 'Firstname' textbox with value is: '" + firstName + "'");
//		registerPage.inputToFirstNameTextbox(firstName);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03:  Input to 'Lastname' textbox with value is: '" + lastName + "'");
//		registerPage.inputToLastNameTextbox(lastName);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05:  Input to 'Password' textbox with value is: '" + password + "'");
//		registerPage.inputToPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06:  Input to 'Confirm Password' textbox with value is: '" + password + "'");
//		registerPage.inputToConfirmPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
//		
//		ExtentTestManager.endTest();
//	}
//	
//	@Test
//	public void User_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_Login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
//		homePage = registerPage.clickToContinueButton();
//		loginPage = homePage.clickToLoginLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02:  Input to 'Email' textbox with value is: '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03:  Input to 'Password' textbox with value is: '" + password + "'");
//		loginPage.inputToPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button");
//		homePage = loginPage.clickToLoginButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplay());
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'Customer Info' page");
//		customerInfoPage = homePage.clickToMyAccountLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Info' page is displayed");
//		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
//		
//		ExtentTestManager.endTest();
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//}
