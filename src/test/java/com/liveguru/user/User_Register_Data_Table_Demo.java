package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.liveGuru.user.UserHomePageObject;
import pageObject.liveGuru.user.UserLoginPageObject;
import pageObject.liveGuru.user.UserMyDashboardPageObject;
import pageObject.liveGuru.admin.AdminLoginPageObject;
import pageObject.liveGuru.admin.AdminManageCustomersPageObject;
import pageObject.liveGuru.user.PageGeneratorManager;
import pageObject.liveGuru.user.UserRegisterPageObject;

public class User_Register_Data_Table_Demo extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserMyDashboardPageObject userMyDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminManageCustomersPageObject adminManageCustomersPage;
	private String firstName, lastName, emailAddress, userPassword, adminUserName, adminPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "test" + generationNumber() + "@mail.com";
		userPassword = "test1234";
		adminUserName = "user01";
		adminPassword = "guru99com";
		
		userHomePage = PageGeneratorManager.getHomePage(driver);
		userLoginPage = userHomePage.clickToMyAccountLink();
		userRegisterPage = userLoginPage.clickToCreateAnAccountButton();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailAddressTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		userMyDashboardPage = userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userMyDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		userHomePage = userMyDashboardPage.clickToLogoutLink();
	}
	
	@Test
	public void User_01_Register_And_Verify_User() {
		userHomePage = PageGeneratorManager.getHomePage(driver);
		userLoginPage = userHomePage.clickToMyAccountLink();
		
		userLoginPage.inputToEmailAddressTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(userPassword);
		userMyDashboardPage = userLoginPage.clickToLoginButton();
		Assert.assertEquals(userMyDashboardPage.getWelcomeMessage(), "Hello," + " " + firstName + " " + lastName + "!");
		userHomePage = userMyDashboardPage.clickToLogoutLink();
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_TECH_PANDA_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminLoginPage.inputToAdminUserNameTextbox(adminUserName);
		adminLoginPage.inputToAdminPasswordTextbox(adminPassword);
		adminManageCustomersPage = adminLoginPage.clickToLoginButton();
		
		adminManageCustomersPage.inputToTextboxAtFilterArea("Name", "name", lastName);
		adminManageCustomersPage.inputToTextboxAtFilterArea("Email", "email", emailAddress);
		adminManageCustomersPage.clickToSearchButton();
		
		Assert.assertEquals(adminManageCustomersPage.getSearchResultValueByColumName("Name", "1"), firstName + " " + lastName);
		Assert.assertEquals(adminManageCustomersPage.getSearchResultValueByColumName("Email", "1"), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
