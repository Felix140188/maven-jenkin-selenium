package pageObject.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.liveGuru.user.PageGeneratorManager;
import pageUIs.liveGuru.admin.AdminLoginPageUI;
import pageUIs.liveGuru.admin.AdminManageCustomersPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void inputToAdminUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, adminUserName);
	}

	public void inputToAdminPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}
	
	public AdminManageCustomersPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		
		if(isElementDisplayed(driver, AdminManageCustomersPageUI.MESSAGE_POPUP)) {
			clickToElement(driver, AdminManageCustomersPageUI.CLOSE_POPUP_BUTTON);
		}
		
		return PageGeneratorManager.getAdminManageCustomersPage(driver);
	}
}
