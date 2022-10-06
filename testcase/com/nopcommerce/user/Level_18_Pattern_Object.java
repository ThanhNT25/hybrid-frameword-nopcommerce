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

public class Level_18_Pattern_Object extends BaseTest {
  private WebDriver driver;
  private String  existingEmail;
  private String firstName, lastName, correctPassword, confirmPassword;
  private String date, month, year;
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
	  date = "10";
	  month ="August";
	  year ="1994";
	  
  }
  
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Open Register page");
	  userRegisterPage = userHomePage.clickToRegisterLink();
	  
	  userRegisterPage.clickToRadioButtonByLabel(driver,"Female");
	  	
	  log.info("Register - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
	  userRegisterPage.inputToTextboxByID(driver, "FirstName", firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value '" + lastName + "'");
	  userRegisterPage.inputToTextboxByID(driver, "LastName", lastName);
	  
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthDay",date);
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthMonth",month);
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthYear",year);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value '" + existingEmail + "'");
	  userRegisterPage.inputToTextboxByID(driver, "Email", existingEmail);
	  
	  userRegisterPage.clickToCheckboxByLabel(driver,"Newsletter");
	  
	  log.info("Register - Step 05: Enter to Password textbox with value '" + correctPassword + "'");
	  userRegisterPage.inputToTextboxByID(driver, "Password", correctPassword);
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value '" + confirmPassword + "'");
	  userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword",confirmPassword);
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  userRegisterPage.clickToButtonByText(driver, "Register");
	  
	  log.info("Register - Step 08: Verify resiger success message is displayed");
	  Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  log.info("Register - Step 09: Click to Logout link");
	  userHomePage = userRegisterPage.clickToLogoutLink();
	  
  }
  
  @Test
  public void User_02_Login() {
	  log.info("Login - Step 01: Navifate to Login page");
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '"+ existingEmail +"'");
	  userLoginPage.inputToTextboxByID(driver,"Email",existingEmail);	
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '"+ correctPassword +"'");
	  userLoginPage.inputToTextboxByID(driver,"Password",correctPassword);	
	  
	  log.info("Login - Step 04: Click to Login button");
	  //userHomePage = userLoginPage.clickToLoginButton();
	  userLoginPage.clickToButtonByText(driver,"Log in");
	  userHomePage =  PageGeneratorManager.getUserHomePage(driver);
	  
	  log.info("Login - Step 05: Verify 'My Account' link is displayed");
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  log.info("Login - Step 06: Click to 'My Account' link ");
	  userCustomerInfoPage = userHomePage.clickToMyAccountLink();
	  
	  log.info("Login - Step 07: Verify 'My Account' link is displayed");
	  Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplay());
  }
  
  @Test
  public void User_03_My_Account() {
	  log.info("My Account - Step 1: Navigate to 'My Account' page");
	  userCustomerInfoPage = userHomePage.openCustomerInfoPage(driver);
	  
	  log.info("My Account - Step 2: Verify 'Customer Infor' page is display");
	  Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplay());
	  
	  log.info("My Account - Step 3: Verify 'First Name' value is correctly");
	  Assert.assertEquals(userCustomerInfoPage.getTextboxValueByID(driver,"FirstName"), firstName);
	  
	  log.info("My Account - Step 4: Verify 'Last Name' value is correctly");
	  Assert.assertEquals(userCustomerInfoPage.getTextboxValueByID(driver,"LastName"), lastName);
	  
	  log.info("My Account - Step 5: Verify 'Email' value is correctly");
	  Assert.assertEquals(userCustomerInfoPage.getTextboxValueByID(driver,"Email"), existingEmail);
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
  
  public int generateNumber() {
	  Random rand = new Random();
	  return rand.nextInt(999);
  }
  

}
