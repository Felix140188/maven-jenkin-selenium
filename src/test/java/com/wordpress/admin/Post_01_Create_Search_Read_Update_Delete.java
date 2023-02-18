package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePagePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchResultPO;

public class Post_01_Create_Search_Read_Update_Delete extends BaseTest {
	private WebDriver driver;
	private AdminLoginPO adminLoginpage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private AdminPostSearchPO adminPostSearchPage;
	private UserHomePagePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchResultPO UserSearchResultPage;
	private String adminUsername = "felix";
	private String adminPassword = "Tstautomation1234@";
	private int randomNumber = generationNumber();
	private String postTitle = "Post Title " + randomNumber;
	private String postBody = "Post Body " + randomNumber;
	private String editedPostTitle = "Edited Post Title " + randomNumber;
	private String editedpostBody = "Edited Post Body " + randomNumber;
	private String postSearchPageUrl;
	private String authorName = "felix";
	private String urlAdmin, urlUser;
	private String currentDate = getCurrentSystemDate();

	@Parameters({ "browser", "urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		
		log.info("Pre-Condition - Step 01: Open Admin site");
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getBrowserDriver(browserName, this.urlAdmin);
		adminLoginpage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Input to 'Username' textbox with value: " + adminUsername);
		adminLoginpage.inputToAdminUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03:  Input to 'Username' textbox with value: " + adminPassword);
		adminLoginpage.inputToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to 'Log in' button");
		adminDashboardPage = adminLoginpage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create Post - Step 01: Click to 'Posts' menu");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();
		
		log.info("Create Post - Step 02:  Get Post Search Page url");
		postSearchPageUrl = adminPostSearchPage.getCurrentPageUrl(driver);
		
		log.info("Create Post - Step 03:  Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create Post - Step 04: Input to Post title textbox with value: " + postTitle);
		adminPostAddNewPage.inputToPostTitleTextbox(postTitle);
		
		log.info("Create Post - Step 05: Input to Post body block with value: " + postBody);
		adminPostAddNewPage.inputToPostBodyTextbox(postBody);
		
		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();
		
		log.info("Create Post - Step 07: Click to Pre 'Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Post Search - Step 01: Open Post Search Page");
		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageUrl(postSearchPageUrl);
		
		log.info("Post Search - Step 02: Input to Search Textbox with value: " + postTitle);
		adminPostSearchPage.inputToSearchTextbox(postTitle);
		
		log.info("Post Search - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Post Search - Step 04: Verify Post Title is displayed in data table as value: " + postTitle);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));
		
		log.info("Post Search - Step 05: Verify Author is displayed in data table as value: " + authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Post Search - Step 06: Open User site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);
		
		log.info("Post Search - Step 07: Verify Post's info is displayed");
		verifyTrue(userHomePage.isPostTitleInfoDisplayed(postTitle));
		verifyTrue(userHomePage.isPostBodyInfoDisplayed(postTitle, postBody));
		verifyTrue(userHomePage.isPostPostedDateInfoDisplayed(postTitle, currentDate));
		verifyTrue(userHomePage.isPostAuthorInfoDisplayed(postTitle, authorName));
		
		log.info("Post Search - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Post Search - Step 09: Verify Post's info is displayed at Post Detail page");
		verifyTrue(userPostDetailPage.PostDetailTitleInfoDisplayed(postTitle));
		verifyTrue(userPostDetailPage.PostDetailBodyInfoDisplayed(postTitle, postBody));
		verifyTrue(userPostDetailPage.PostDetailPostedDateInfoDisplayed(postTitle, currentDate));
		verifyTrue(userPostDetailPage.PostDetailAuthorInfoDisplayed(postTitle, authorName));
	}
	
	@Test
	public void Post_03_Edit_Post() {
		log.info("Post Edit - Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.urlAdmin);
		
		log.info("Post Edit - Step 02: Click to 'Posts' menu");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();
		
		log.info("Post Edit - Step 03: Input to Search Textbox with value: " + postTitle);
		adminPostSearchPage.inputToSearchTextbox(postTitle);
		
		log.info("Post Edit - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Post Edit - Step 05: Click to Post title and navigate to Post edit page");
		adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		log.info("Post Edit - Step 06: Input to Post title textbox with value: " + editedPostTitle);
		adminPostAddNewPage.inputToPostTitleTextbox(editedPostTitle);
		
		log.info("Post Edit - Step 07: Input to Post body block with value: " + editedpostBody);
		adminPostAddNewPage.inputToEditPostBodyTextbox(editedpostBody);
		
		log.info("Post Edit - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();
		
		log.info("Post Edit - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post updated."));
		
		log.info("Post Edit - Step 10: Open Post Search Page");
		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageUrl(postSearchPageUrl);
		
		log.info("Post Edit - Step 11: Input to Search Textbox with value: " + editedPostTitle);
		adminPostSearchPage.inputToSearchTextbox(editedPostTitle);
		
		log.info("Post Edit - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Post Edit - Step 13: Verify Post Title is displayed in data table as value: " + editedPostTitle);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editedPostTitle));
		
		log.info("Post Edit - Step 14: Verify Author is displayed in data table as value: " + authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Post Edit - Step 15: Open User site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);
		
		log.info("Post Edit - Step 16: Verify Post's info is displayed at Home page");
		verifyTrue(userHomePage.isPostTitleInfoDisplayed(editedPostTitle));
		verifyTrue(userHomePage.isPostBodyInfoDisplayed(editedPostTitle, editedpostBody));
		verifyTrue(userHomePage.isPostPostedDateInfoDisplayed(editedPostTitle, currentDate));
		verifyTrue(userHomePage.isPostAuthorInfoDisplayed(editedPostTitle, authorName));
		
		log.info("Post Edit - Step 17: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editedPostTitle);
		
		log.info("Post Edit - Step 18: Verify Post's info is displayed at Post Detail page");
		verifyTrue(userPostDetailPage.PostDetailTitleInfoDisplayed(editedPostTitle));
		verifyTrue(userPostDetailPage.PostDetailBodyInfoDisplayed(editedPostTitle, editedpostBody));
		verifyTrue(userPostDetailPage.PostDetailPostedDateInfoDisplayed(editedPostTitle, currentDate));
		verifyTrue(userPostDetailPage.PostDetailAuthorInfoDisplayed(editedPostTitle, authorName));
	}
	
	@Test
	public void Post_04_Delete_Post() {
		log.info("Post Delete - Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.urlAdmin);
		
		log.info("Post Delete - Step 02: Click to 'Posts' menu");
		adminPostSearchPage = adminDashboardPage.clickToPostMenu();
		
		log.info("Post Delete - Step 03: Input to Search Textbox with value: " +editedPostTitle);
		adminPostSearchPage.inputToSearchTextbox(editedPostTitle);
		
		log.info("Post Delete - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Post Delete - Step 05: Select checkbox of search result");
		adminPostSearchPage.clickToCheckboxByLabel(editedPostTitle);
		
		log.info("Post Delete - Step 06: Select option 'Move to Trash' in Action Dropdown");
		adminPostSearchPage.selectOptionInActionDropdown("Move to Trash");
		
		log.info("Post Delete - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();
		
		log.info("Post Delete - Step 08: Verify '1 post moved to the Trash.' message is displayed ");
		verifyTrue(adminPostSearchPage.isDeleteSuccessMessageDisplayed("1 post moved to the Trash."));
		
		log.info("Post Delete - Step 09: Input to Search Textbox with value: " +editedPostTitle);
		adminPostSearchPage.inputToSearchTextbox(editedPostTitle);
		
		log.info("Post Delete - Step 10: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Post Delete - Step 11: Verify 'No posts found.' message is displayed ");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDisplayed("No posts found."));
		
		log.info("Post Delete - Step 12: Open User site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);
		
		log.info("Post Delete - Step 13: Verify Post's Title is undisplayed at Home page");
		verifyTrue(userHomePage.isPostInfoUnDisplayedByPostTitle(editedPostTitle));
		
		log.info("Post Delete - Step 14: Input to Search Textbox at Sidebar with value: " +editedPostTitle);
		userHomePage.inputToSearchTextbox(editedPostTitle);
		
		log.info("Post Delete - Step 15: Click to 'Search' button");
		UserSearchResultPage = userHomePage.clickToSearchButton();
		
		log.info("Post Delete - Step 16: Verify 'Nothing Found' message is displayed ");
		verifyTrue(UserSearchResultPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
