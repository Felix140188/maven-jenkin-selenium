package pageObjects.swaglabs;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.swaglabs.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameField(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_FIELD);
		sendkeyToElement(driver, LoginPageUI.USERNAME_FIELD, userName);
	}

	public void inputToPasswordField(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_FIELD);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_FIELD, password);
	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
}
