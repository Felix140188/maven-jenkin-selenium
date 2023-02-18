package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.user.UserHomePageObject;
import pageObject.liveGuru.user.UserLoginPageObject;
import pageObject.liveGuru.user.UserMyDashboardPageObject;
import pageObject.liveGuru.user.PageGeneratorManager;
import pageObject.liveGuru.user.UserRegisterPageObject;

public class User_Page_Generator_Manager extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserMyDashboardPageObject myDashboardPage;
	private String firstName, lastName, emailAddress, password;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "test" + generationNumber() + "@mail.com";
		password = "test1234";
	}
	
	@Test
	public void User_01_Register_To_Systerm() {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		homePage = myDashboardPage.clickToLogoutLink();
	}
	
	@Test
	public void User_02_Login_To_Systerm() {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertEquals(myDashboardPage.getWelcomeMessage(), "Hello," + " " + firstName + " " + lastName + "!");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
