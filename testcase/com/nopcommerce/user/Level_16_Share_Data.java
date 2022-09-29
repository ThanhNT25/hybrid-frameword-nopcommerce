package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

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

public class Level_16_Share_Data extends BaseTest {
  private WebDriver driver;
  private String  existingEmail ;
  private String correctPassword ;
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
	  
	  existingEmail = Common_01_Register.emailAddress;
	  correctPassword = Common_01_Register.correctPassword ;
	  
	  log.info("Login - Step 01: Navifate to Login page");
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '"+ existingEmail +"'");
	  userLoginPage.inputToEmailTextbox(existingEmail);	
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '"+ correctPassword +"'");
	  userLoginPage.inputToPasswordTextbox(correctPassword);	
	  
	  log.info("Login - Step 04: Click to Login button");
	  userHomePage = userLoginPage.clickToLoginButton();
	  
  }
    
  @Test
  public void Search_01_Empty_Data() {
	  
	 
  }
  
  @Test
  public void Search_02_Relative_Product_Name() {
	
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
   

}
