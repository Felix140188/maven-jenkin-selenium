package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{
	WebDriver driver;
	
	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void inputToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String headerId, String postTitle) {
		int headerIndex = getWebElementsSize(driver, AdminPostSearchPageUI.POSTS_TABLE_HEADER_INDEX, headerId) +1;
		
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), postTitle);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), postTitle);
	}

	public void clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.TABLE_POST_TITLE_LINK, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.TABLE_POST_TITLE_LINK, postTitle);
	}

	public void clickToCheckboxByLabel(String editedPostTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_lABEL, editedPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_lABEL, editedPostTitle);
	}

	public void selectOptionInActionDropdown(String dropdownOption) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownOption);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ACTION_APPLY_BUTTON);
	}

	public boolean isDeleteSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, AdminPostSearchPageUI.DELETE_SUCCESS_MESSAGE, successMessage);
		return isElementDisplayed(driver, AdminPostSearchPageUI.DELETE_SUCCESS_MESSAGE, successMessage);
	}

	public boolean isNoPostsFoundMessageDisplayed(String noPostFoundMessage) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, noPostFoundMessage);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, noPostFoundMessage);
	}

}
