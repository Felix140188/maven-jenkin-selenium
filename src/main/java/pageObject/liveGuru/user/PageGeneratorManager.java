package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import pageObject.liveGuru.admin.AdminLoginPageObject;
import pageObject.liveGuru.admin.AdminManageCustomersPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserMyDashboardPageObject getUserMyDashboardPage(WebDriver driver) {
		return new UserMyDashboardPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminManageCustomersPageObject getAdminManageCustomersPage(WebDriver driver) {
		return new AdminManageCustomersPageObject(driver);
	}

}
