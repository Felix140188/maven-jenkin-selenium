package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.user.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public UserMyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
		return getElementText(driver, UserMyDashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
	}
	
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
		clickToElement(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
		waitForElementClickable(driver, UserMyDashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, UserMyDashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getWelcomeMessage() {
		waitForElementVisible(driver, UserMyDashboardPageUI.WELCOME_MESSAGE);
		return getElementText(driver, UserMyDashboardPageUI.WELCOME_MESSAGE);
	}

}
