package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
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

public class Level_09_Dynamic_Locator extends BaseTest {
  private WebDriver driver;
  private String  existingEmail;
  private String firstName, lastName, correctPassword, confirmPassword;
  private UserHomePageObject userHomePage  ;
  private UserRegisterPageObject userRegisterPage  ;
  private UserLoginPageObject userLoginPage;
  private UserCustomerInfoPageObject userCustomerInfoPage;
  private UserAddressPageObject userAddressPage;
  private UserMyProductReviewPageObject userMyProductReviewPage;
  private UserRewardPointPageObject userRewardPointPage;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  existingEmail = "auto"+generateNumber()+"@gmail.com";
	  firstName = "Automation";
	  lastName = "FC";
	  correctPassword ="123456";
	  confirmPassword = "123456";
	  
  }
  
  @Test
  public void User_01_Register_Login() {
	  
	  userRegisterPage = userHomePage.clickToRegisterLink();
	  	  
	  userRegisterPage.inputToFirstnameTextbox(firstName);
	  userRegisterPage.inputToLastnameTextbox(lastName);
	  userRegisterPage.inputToEmailTextbox(existingEmail);
	  userRegisterPage.inputToPasswordTextbox(correctPassword);
	  userRegisterPage.inputToConfirmPasswordTextbox(confirmPassword);
	  userRegisterPage.clickToRegisterButton();
	  
	  userHomePage = userRegisterPage.clickToLogoutLink();
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  userLoginPage.inputToEmailTextbox(existingEmail);	
	  userLoginPage.inputToPasswordTextbox(correctPassword);	
	  userHomePage = userLoginPage.clickToLoginButton();
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  userCustomerInfoPage = userHomePage.clickToMyAccountLink();
	  Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplay());

  }
  
  
  @Test
  public void User_02_Switch_Page() {
	  
	  userAddressPage = userCustomerInfoPage.openAddressPage(driver);
	  
	  userMyProductReviewPage = userAddressPage.openMyProductReviewPage(driver);
	  
	  userRewardPointPage = userMyProductReviewPage.openRewardPointPage(driver);
	  	  
	  userAddressPage = userRewardPointPage.openAddressPage(driver);
	  
	  userRewardPointPage = userAddressPage.openRewardPointPage(driver);

	  userMyProductReviewPage = userRewardPointPage.openMyProductReviewPage(driver);
  }
  
  @Test
  public void User_03_Dynamic_Page_01() {
	  
	 userRewardPointPage = (UserRewardPointPageObject) userMyProductReviewPage.openPageAtMyAccountByName(driver,"Reward points");
	  
	 userAddressPage = (UserAddressPageObject) userRewardPointPage.openPageAtMyAccountByName(driver,"Addresses");
	 
	 userRewardPointPage = (UserRewardPointPageObject) userMyProductReviewPage.openPageAtMyAccountByName(driver,"Reward points");
	  
	 userMyProductReviewPage = (UserMyProductReviewPageObject) userRewardPointPage.openPageAtMyAccountByName(driver,"My product reviews");
	 
	 userCustomerInfoPage = (UserCustomerInfoPageObject) userMyProductReviewPage.openPageAtMyAccountByName(driver, "Customer info");
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
