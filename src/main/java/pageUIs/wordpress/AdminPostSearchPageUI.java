package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='page-title-action' and text()='Add New']";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";
	public static final String POSTS_TABLE_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String TABLE_POST_TITLE_LINK = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_lABEL = "xpath=//table[contains(@class,'table-view-list posts')]/tbody//label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String ACTION_APPLY_BUTTON = "css=input#doaction";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td[text()='%s']";
	public static final String DELETE_SUCCESS_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	
}
