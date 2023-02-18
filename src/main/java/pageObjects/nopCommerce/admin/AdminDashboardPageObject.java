package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderDisplayed() {
		waitForAllElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
	}
}
