package com.wordpress.admin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.wordpress.admin.AdminDashboardPO;
import pageObject.wordpress.admin.AdminLoginPO;
import pageObject.wordpress.admin.AdminPostAddNewPO;
import pageObject.wordpress.admin.AdminPostSearchPO;
import pageObject.wordpress.admin.PageGeneratorManager;
import pageObject.wordpress.admin.UserHomePO;
import pageObject.wordpress.admin.UserPostDetailPO;
import pageObject.wordpress.admin.UserPostSearchPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostSearchPO userPostSearchPage;
	UserPostDetailPO userPostDetailPage;
	
	String adminUsername = "automation";
	String adminPassword = "automation";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody ="Live Codung Body " + randomNumber;
	String postTitleUpdate = "Update Live Coding Title" + randomNumber;
	String postBodyUpdate ="Update Live Codung Body " + randomNumber;
	String authorName = "automation";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();
	
	@Parameters({"browser","urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " +adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value: " +adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
		
		
	}
	
	@Test
	public void Post_01_Create_Post() {
		log.info("Create_Post - Step 01: Click to 'Post' menu link");
		adminPostSearchPage= adminDashboardPage.clickToPostMenuLink();
		
		log.info("Create_Post - Step 02: Get 'Search Post' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage= adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click to 'Public' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Click to 'Pre-Public' button");
		adminPostAddNewPage.clickToPrePublishOrUpdateButton();
		
		log.info("Create_Post - Step 08: Verify 'Post published' message is display");
		VerifyTrue(adminPostAddNewPage.isPostPublishMessageDissplay("Post published."));
		
	}
	
	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");		
		adminPostSearchPage =  adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Search_Post - Step 02: Enter to search textbox");	
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03: Click to 'Search Posts' button");	
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'");
		VerifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",postTitle));
		
		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		VerifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Search_Post - Step 07: Verify Post infor display at Home page");
		VerifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		VerifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		VerifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		VerifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
		
		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor display at Post detail page");
		VerifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		VerifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		VerifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		VerifyTrue(userPostDetailPage.isPostInforDisplayedWithPostDay(postTitle, currentDay));
		
	}
	
	@Test
	public void TC_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin url");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		
		log.info("Edit_Post - Step 02: Click to 'Post' menu link");
		adminPostSearchPage= adminDashboardPage.clickToPostMenuLink();
		
		log.info("Edit_Post - Step 03: Enter to search textbox");	
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Edit_Post - Step 04: Click to 'Search Posts' button");	
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit_Post - Step 05: Click to Post title link and navigate to Edit Post page");	
		adminPostSearchPage.clickToPostTitleLink(postTitle);
		
		log.info("Edit_Post - Step 06: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleUpdate);
		
		log.info("Edit_Post - Step 07: Enter to body");
		adminPostAddNewPage.enterToEditPostBody(postBodyUpdate);
		
		log.info("Edit_Post - Step 08: Click to 'Pre-Public' button");
		adminPostAddNewPage.clickToPrePublishOrUpdateButton();
		
		log.info("Edit_Post - Step 09: Verify 'Post published' message is display");
		VerifyTrue(adminPostAddNewPage.isPostPublishMessageDissplay("Post updated."));
		
		
	}
	
	@AfterClass(alwaysRun = true)
	  public void afterClass() {
		  closeBrowserAndDriver();
	  }

}
