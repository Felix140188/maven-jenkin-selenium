package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePagePO extends BasePage{
	WebDriver driver;
	
	public UserHomePagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleInfoDisplayed(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostBodyInfoDisplayed(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostPostedDateInfoDisplayed(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserHomePageUI.POSTED_DATE_TEXT_BY_POST_TITLE, postTitle, currentDate);
		return isElementDisplayed(driver, UserHomePageUI.POSTED_DATE_TEXT_BY_POST_TITLE, postTitle, currentDate);
	}

	public boolean isPostAuthorInfoDisplayed(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
	}
	
	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public void inputToSearchTextbox(String editedPostTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, editedPostTitle);
	}

	public UserSearchResultPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchResultPage(driver);
	}

	public boolean isPostInfoUnDisplayedByPostTitle(String editedPostTitle) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editedPostTitle);
	}
}
