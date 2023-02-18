package pageUIs.jQuery.dataTable;

public class HomePageUI {
	// jquery-CRUD-Data-Grid
	public static final String PAGINATION_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_ACTIVE_PAGE_NUMBER = "xpath=//li[contains(@class,'pagination')]/a[contains(@class,'active') and text()='%s']";
	public static final String TABLE_HEADER_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li";
	public static final String PAGINATION_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	
	// jquery-Dynamic-Data-Grid
	public static final String LOAD_BUTTON = "css=button#load";
	public static final String COLUMN_INDEX_BY_HEADER = "xpath=//thead//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_INDEX_BY_COLUMN_AND_ROW = "xpath=//tbody//tr[%s]/td[%s]/input";
	public static final String DROPDOWN_INDEX_BY_COLUMN_AND_ROW = "xpath=//tbody//tr[%s]/td[%s]//select";
	public static final String CHECKBOX_INDEX_BY_COLUMN_AND_ROW = "xpath=//tbody//tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW = "xpath=//tbody/tr[%s]//button[@title='%s']";
}
