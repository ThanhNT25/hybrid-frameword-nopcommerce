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
import pageObject.wordpress.admin.AdminUserPO;
import pageObject.wordpress.admin.PageGeneratorManager;
import pageObject.wordpress.admin.UserHomePO;
import pageObject.wordpress.admin.UserPostDetailPO;
import pageObject.wordpress.admin.UserSearchPostPO;

public class User_01_View_User extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	AdminUserPO adminUserPage;
	UserHomePO userHomePage;
	UserSearchPostPO userPostSearchPage;
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
	public void Post_01_View_User() {
		log.info("View_User - Step 01: Click to 'User' menu link");
		adminUserPage= adminDashboardPage.clickToUserMenuLink();
		
		log.info("View_User - Step 02: Get all User from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
		System.out.println("Total number on UI = " + totalNumberUserAtUI);
		
		log.info("View_User - Step 03: Get all users form DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
		System.out.println("Total number on DB = " + totalNumberUserAtDB);
		
		log.info("View_User - Step 04: Verify the user");
		verifyEquals(totalNumberUserAtUI,totalNumberUserAtDB);
		
				
	}

	
	@AfterClass(alwaysRun = true)
	  public void afterClass() {
		  closeBrowserAndDriver();
	  }

}
