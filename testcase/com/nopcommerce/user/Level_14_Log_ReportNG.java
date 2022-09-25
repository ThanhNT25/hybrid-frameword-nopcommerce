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

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_14_Log_ReportNG extends BaseTest {
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
  public void User_01_Register() {
	  log.info("Register - Step 01: Open Register page");
	  userRegisterPage = userHomePage.clickToRegisterLink();
	  	
	  log.info("Register - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
	  userRegisterPage.inputToFirstnameTextbox(firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value '" + lastName + "'");
	  userRegisterPage.inputToLastnameTextbox(lastName);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value '" + existingEmail + "'");
	  userRegisterPage.inputToEmailTextbox(existingEmail);
	  
	  log.info("Register - Step 05: Enter to Password textbox with value '" + correctPassword + "'");
	  userRegisterPage.inputToPasswordTextbox(correctPassword);
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value '" + confirmPassword + "'");
	  userRegisterPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  userRegisterPage.clickToRegisterButton();
	  
	  log.info("Register - Step 08: Verify resiger success message is displayed");
	  verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed..");
	  
	  log.info("Register - Step 09: Click to Logout link");
	  userHomePage = userRegisterPage.clickToLogoutLink();
	 

  }
  
  @Test
  public void User_02_Login() {
	  log.info("Login - Step 01: Navifate to Login page");
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '"+ existingEmail +"'");
	  userLoginPage.inputToEmailTextbox(existingEmail);	
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '"+ correctPassword +"'");
	  userLoginPage.inputToPasswordTextbox(correctPassword);	
	  
	  log.info("Login - Step 04: Click to Login button");
	  userHomePage = userLoginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify 'My Account' link is displayed");
	  VerifyTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  log.info("Login - Step 06: Click to 'My Account' link ");
	  userCustomerInfoPage = userHomePage.clickToMyAccountLink();
	  
	  log.info("Login - Step 07: Verify 'My Account' link is displayed");
	  VerifyTrue(userCustomerInfoPage.isCustomerInfoPageDisplay());
  }
  
  
  @Test
  public void User_03_Switch_Page() {
	  
	  userAddressPage = userCustomerInfoPage.openAddressPage(driver);
	  
	  userMyProductReviewPage = userAddressPage.openMyProductReviewPage(driver);
	  
	  userRewardPointPage = userMyProductReviewPage.openRewardPointPage(driver);
	  	  
	  userAddressPage = userRewardPointPage.openAddressPage(driver);
	  
	  userRewardPointPage = userAddressPage.openRewardPointPage(driver);

	  userMyProductReviewPage = userRewardPointPage.openMyProductReviewPage(driver);
  }
  
  @Test
  public void User_04_Dynamic_Page_01() {
	  
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
