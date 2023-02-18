package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;
import pageUIs.wordpress.UserSearchResultPageUI;

public class UserSearchResultPO extends BasePage{
	WebDriver driver;
	
	public UserSearchResultPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String nothingFoundMessage) {
		waitForElementVisible(driver, UserSearchResultPageUI.NOTHING_FOUND_MESSAGE, nothingFoundMessage);
		return isElementDisplayed(driver, UserSearchResultPageUI.NOTHING_FOUND_MESSAGE, nothingFoundMessage);
	}

}
