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

public class Level_07_Switch_Page extends BaseTest {
  private WebDriver driver;
  private String  existingEmail;
  private String firstName, lastName, correctPassword, confirmPassword;
  private UserHomePageObject homePage  ;
  private UserRegisterPageObject registerPage  ;
  private UserLoginPageObject loginPage;
  private UserCustomerInfoPageObject customerInfoPage;
  private UserAddressPageObject addressPage;
  private UserMyProductReviewPageObject myProductReviewPage;
  private UserRewardPointPageObject rewardPointPage;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  existingEmail = "auto"+generateNumber()+"@gmail.com";
	  firstName = "Automation";
	  lastName = "FC";
	  correctPassword ="123456";
	  confirmPassword = "123456";
	  
  }
  
  @Test
  public void User_01_Register() {
	  
	  System.out.println("Pre - Condition Step 01: Click to Register link");
	  registerPage = homePage.clickToRegisterLink();
	  	  
	  System.out.println("Pre - Condition Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(correctPassword);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Pre - Condition Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Pre - Condition Step 05: Click to Logout link");
	  homePage = registerPage.clickToLogoutLink();
  }
  
  @Test
  public void User_02_Login() {
	  System.out.println("Login_04 Step 01: Click to Login link");
	  loginPage = homePage.clickToLoginLink();
	  	  
	  System.out.println("Login_04 Step 02: Input email existing to Email Textbox");
	  loginPage.inputToEmailTextbox(existingEmail);	
	  
	  System.out.println("Login_04 Step 03: Input invalid password correct to Password Textbox");
	  loginPage.inputToPasswordTextbox(correctPassword);	
	  
	  System.out.println("Login_04 Step 04: Click to LOGIN button");
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
  }
  
  @Test
  public void User_03_My_Account() {
	  
	  customerInfoPage = homePage.clickToMyAccountLink();
	  Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplay());
	  	 
  }
  
  @Test
  public void User_04_Switch_Page() {
	  
	  addressPage = customerInfoPage.openAddressPage(driver);
	  
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	  
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	  
	  addressPage = myProductReviewPage.openAddressPage(driver);
	  
	  customerInfoPage = addressPage.openCustomerInfoPage(driver);
  }
  
  @Test
  public void User_05_Switch_Role() {
	
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
