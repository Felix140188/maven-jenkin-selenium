package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POSTED_DATE_TEXT_BY_POST_TITLE = "xpath=//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//h1[text()='%s']/parent::header//span[@class='author vcard']/a[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//h1[text()='%s']/ancestor::article//div[@class='entry-content']/p[text()='%s']";
}
