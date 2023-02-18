package pageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Customer info')]";
	public static final String ADDRESSES_LINK ="xpaTh=//div[contains(@class,'account-navigation')]//a[(text()='Addresses')]";
	public static final String ORDERS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Orders')]";
	public static final String DOWNLOADABLE_PRODUCTS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Downloadable products')]";
	public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Back in stock subscriptions')]";
	public static final String REWARD_POINTS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Reward points')]";
	public static final String CHANGE_PASSWORD_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='Change password')]";
	public static final String MY_PRODUCTS_REVIEWS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='My product reviews')]";
	public static final String USER_LOGOUT_LINK = "class=ico-logout";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[contains(text(),'Logout')]";
	
	
	public static final String DYNAMIC_PAGE_AT_SIDE_MENU ="xpath=//div[contains(@class,'account-navigation')]//a[(text()='%s')]";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
}
