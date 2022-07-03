package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role extends BaseTest {
  private WebDriver driver;
  private String  userEmailAddress, userPassword, adminEmailPassword, adminPassword;
  private UserHomePageObject userHomePage  ;
  private UserRegisterPageObject userRegisterPage  ;
  private UserLoginPageObject userLoginPage;
  private UserCustomerInfoPageObject userCustomerInfoPage;
  private UserAddressPageObject userAddressPage;
  private UserMyProductReviewPageObject userMyProductReviewPage;
  private UserRewardPointPageObject userRewardPointPage;
  private AdminDashboardPageObject adminDashboardPage;
  private AdminLoginPageObject adminLoginPage;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  userEmailAddress = "hana32@gmail.com";
	  userPassword ="123456";
	  adminEmailPassword = "admin@yourstore.com";
	  adminPassword = "admin"	;		  
	  
  }
  
  @Test
  public void Role_01_User() {
	  userLoginPage = userHomePage.clickToLoginLink();
	  userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
	  
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
  }
  
  @Test
  public void Role_02_Admin() {
	  userHomePage.openUrlPage(driver, GlobalConstants.ADMIN_PAGE_URL);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  adminLoginPage.loginAsAdmin(adminEmailPassword, adminPassword);
	  adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
	  Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	  
	  
  }
  
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random rand = new Random();
	  return rand.nextInt(999);
  }
  

}
