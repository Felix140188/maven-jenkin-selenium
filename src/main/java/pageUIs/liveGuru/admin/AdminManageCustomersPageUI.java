package pageUIs.liveGuru.admin;

public class AdminManageCustomersPageUI {
	public static final String MESSAGE_POPUP ="xpath=//div[@id='message-popup-window']";
	public static final String CLOSE_POPUP_BUTTON ="xpath=//div[@id='message-popup-window']//span[text()='close']";
	public static final String COLUMN_INDEX_BY_HEADER_NAME ="xpath=//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
	public static final String FILTER_TEXTBOX_BY_COLUMN_NAME ="xpath=//thead/tr[@class='filter']//th[%s]//input[@name='%s']";
	public static final String SEARCH_BUTTON ="xpath=//td[contains(@class,'filter-actions')]/button//span[text()='Search']";
	public static final String TABLE_DATA ="xpath=//table[@id='customerGrid_table']/tbody/tr[%s]/td[%s]";
}
