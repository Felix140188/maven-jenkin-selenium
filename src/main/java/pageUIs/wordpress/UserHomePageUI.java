package pageUIs.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POSTED_DATE_TEXT_BY_POST_TITLE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//span[@class='author vcard']/a[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//aside[@class='widget-area']//input[@id='wp-block-search__input-1']";
	public static final String SEARCH_BUTTON = "xpath=//aside[@class='widget-area']//button[text()='Search']";
}
