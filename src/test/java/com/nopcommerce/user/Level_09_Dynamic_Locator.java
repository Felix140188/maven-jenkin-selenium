package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressesPageObject addressesPage;
	private UserMyProductReviewsPageObject myProductReviewsPage;
	private UserRewardPointsPageObject rewardPointsPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "Testing";
		emailAddress = "test" + generationNumber() + "@mail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToContinueButton();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_02_Switch_Page() {
		// Customer info -> Addresses
		addressesPage = customerInfoPage.openAddressesPage(driver);
		
		// Addresses -> My product reviews
		myProductReviewsPage = addressesPage.openMyProductReviewsPage(driver);
		
		// My product reviews -> Reward points
		rewardPointsPage = myProductReviewsPage.openRewardPointsPage(driver);
		
		// Reward points -> Addresses
		addressesPage = rewardPointsPage.openAddressesPage(driver);
	}
	
	@Test
	public void User_03_Dynamic_Page01() {
		// Addresses -> Reward points
		rewardPointsPage  = (UserRewardPointsPageObject) addressesPage.openPagesOfMyAccountSideMenu(driver, "Reward points");
		
		// Reward points -> My product reviews
		myProductReviewsPage = (UserMyProductReviewsPageObject) rewardPointsPage.openPagesOfMyAccountSideMenu(driver, "My product reviews");
		
		// My product reviews -> Addresses
		addressesPage = (UserAddressesPageObject) myProductReviewsPage.openPagesOfMyAccountSideMenu(driver, "Addresses");
		
		// Addresses -> Customer info
		customerInfoPage = (UserCustomerInfoPageObject) addressesPage.openPagesOfMyAccountSideMenu(driver, "Customer info");

	}
	
	@Test
	public void User_03_Dynamic_Page02() {
		// Customer info -> Addresses
		customerInfoPage.openDynamicPagesMyAccountSideMenu(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		// Addresses -> My product reviews
		addressesPage.openDynamicPagesMyAccountSideMenu(driver, "My product reviews");
		myProductReviewsPage = PageGeneratorManager.getUserMyProductReviewsPage(driver);
		
		// My product reviews -> Reward points
		myProductReviewsPage.openDynamicPagesMyAccountSideMenu(driver, "Reward points");
		rewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);
		
		// Reward points -> Addresses
		rewardPointsPage.openDynamicPagesMyAccountSideMenu(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
