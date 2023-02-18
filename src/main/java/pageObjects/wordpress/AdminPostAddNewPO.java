package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToPostTitleTextbox(String postTitleText) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitleText);
	}
	
	public void inputToPostBodyTextbox(String postBodyText) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BLOCK);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_BLOCK);
		
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_INPUT);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_INPUT, postBodyText);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
	}

	public boolean isPostPublishedMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESS_MESSAGE, successMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESS_MESSAGE, successMessage);
	}

	public AdminPostSearchPO openPostSearchPageUrl(String postSearchPageUrl) {
		openPageUrl(driver, postSearchPageUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

	public void inputToEditPostBodyTextbox(String editedpostBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BLOCK);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_BLOCK);
		
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_INPUT);
		clearTextByDeleteKey(driver, AdminPostAddNewPageUI.POST_BODY_INPUT);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_INPUT, editedpostBody);
	}
}
