package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String POST_TITLE_TEXTBOX = "css=h1[class*='wp-block-post-title']";
	public static final String POST_BODY_BLOCK = "css=div[class*='is-root-container']";
	public static final String POST_BODY_INPUT = "css=p[class*='block-editor-rich-text__editable']";
	public static final String POST_PUBLISH_OR_UPDATE_BUTTON = "css=div.edit-post-header__settings button[class*='editor-post-publish-button']";
	public static final String PRE_PUBLISH_BUTTON = "css=div.editor-post-publish-panel button[class*='editor-post-publish-button']";
	public static final String PUBLISHED_SUCCESS_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
