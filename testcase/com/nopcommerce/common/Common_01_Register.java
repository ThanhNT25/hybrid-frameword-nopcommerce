package com.nopcommerce.common;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Common_01_Register extends BaseTest {
  private WebDriver driver;
  public static String  emailAddress;
  public static String correctPassword;
  private String firstName, lastName, confirmPassword;
  private UserHomePageObject userHomePage  ;
  private UserRegisterPageObject userRegisterPage  ;
  private UserLoginPageObject userLoginPage;
  private UserCustomerInfoPageObject userCustomerInfoPage;
  private UserAddressPageObject userAddressPage;
  private UserMyProductReviewPageObject userMyProductReviewPage;
  private UserRewardPointPageObject userRewardPointPage;
    
  @Parameters("browser")
  @BeforeTest(description = "Create new common Usẻ for all Classes Test")
  public void Register(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  emailAddress = "auto"+generateNumber()+"@gmail.com";
	  firstName = "Automation";
	  lastName = "FC";
	  correctPassword ="123456";
	  confirmPassword = "123456";
	  
	  log.info("Register - Step 01: Open Register page");
	  userRegisterPage = userHomePage.clickToRegisterLink();
	  	
	  log.info("Register - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
	  userRegisterPage.inputToFirstnameTextbox(firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value '" + lastName + "'");
	  userRegisterPage.inputToLastnameTextbox(lastName);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value '" + emailAddress + "'");
	  userRegisterPage.inputToEmailTextbox(emailAddress);
	  
	  log.info("Register - Step 05: Enter to Password textbox with value '" + correctPassword + "'");
	  userRegisterPage.inputToPasswordTextbox(correctPassword);
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value '" + confirmPassword + "'");
	  userRegisterPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  userRegisterPage.clickToRegisterButton();
	  
	  log.info("Register - Step 08: Verify resiger success message is displayed");
	  verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  log.info("Register - Step 09: Click to Logout link");
	  userHomePage = userRegisterPage.clickToLogoutLink();
	 

  }
  

  @AfterTest
  public void afterClass() {
	  driver.quit();
  }
  
  public int generateNumber() {
	  Random rand = new Random();
	  return rand.nextInt(999);
  }
  

}
