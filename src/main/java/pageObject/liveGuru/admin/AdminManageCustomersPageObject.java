package pageObject.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.admin.AdminManageCustomersPageUI;

public class AdminManageCustomersPageObject extends BasePage {
	private WebDriver driver;
	
	public AdminManageCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToTextboxAtFilterArea(String columnName, String textboxName, String inputText) {
		int columnIndex = getWebElementsSize(driver, AdminManageCustomersPageUI.COLUMN_INDEX_BY_HEADER_NAME, columnName) +1;
		
		waitForElementVisible(driver, AdminManageCustomersPageUI.FILTER_TEXTBOX_BY_COLUMN_NAME, String.valueOf(columnIndex), textboxName);
		sendkeyToElement(driver, AdminManageCustomersPageUI.FILTER_TEXTBOX_BY_COLUMN_NAME, inputText, String.valueOf(columnIndex), textboxName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminManageCustomersPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminManageCustomersPageUI.SEARCH_BUTTON);
	}

	public String getSearchResultValueByColumName(String columnName, String rowNumber) {
		int columnIndex = getWebElementsSize(driver, AdminManageCustomersPageUI.COLUMN_INDEX_BY_HEADER_NAME, columnName) +1;
		
		waitForElementVisible(driver, AdminManageCustomersPageUI.TABLE_DATA, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, AdminManageCustomersPageUI.TABLE_DATA, rowNumber, String.valueOf(columnIndex));
	}

}
