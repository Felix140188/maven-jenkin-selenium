package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_ACTIVE_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_ACTIVE_PAGE_NUMBER, pageNumber);
	}

	public void inputToHeaderTextbox(String headerLabel, String inputText) {
		waitForElementVisible(driver, HomePageUI.TABLE_HEADER_TEXTBOX, headerLabel);
		sendkeyToElement(driver, HomePageUI.TABLE_HEADER_TEXTBOX, inputText, headerLabel);
		pressKeyToElement(driver, HomePageUI.TABLE_HEADER_TEXTBOX, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowOfAllPage() {
		int totalPage = getWebElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total page: " + totalPage);
		
		List<String> allRowValuesOfAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_INDEX, String.valueOf(index));
			
			List<WebElement> allRowValuesOfEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowValuesOfEachPage) {
				allRowValuesOfAllPage.add(eachRow.getText());
			}
		}
		
		for (String value : allRowValuesOfAllPage) {
			System.out.println("--------------------------------------");
			System.out.println(value);
		}
		return allRowValuesOfAllPage;
	}

	public void inputToTextboxByColumnNameAtTargetRow(String columnName, String rowNumber, String inputText) {
		int columnIndex = getWebElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_INDEX_BY_COLUMN_AND_ROW, rowNumber,  String.valueOf(columnIndex));
		sendkeyToElement(driver,HomePageUI.TEXTBOX_INDEX_BY_COLUMN_AND_ROW, inputText, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtTargetRow(String columnName, String rowNumber, String optionText) {
		int columnIndex = getWebElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DROPDOWN_INDEX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_INDEX_BY_COLUMN_AND_ROW, optionText, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
		sleepInSecond(2);
	}

	public void checkToCheckboxByColumnNameAtTargetRow(String columnName, String rowNumber) {
		int columnIndex = getWebElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtTargetRow(String columnName, String rowNumber) {
		int columnIndex = getWebElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_HEADER, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_INDEX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconAtTargetRow(String rowNumber, String iconTitle) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW, rowNumber, iconTitle);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW, rowNumber, iconTitle);
		sleepInSecond(1);
	}
	
}
