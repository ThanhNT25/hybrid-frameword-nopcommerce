package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_20_Manage_Data extends BaseTest {
  private WebDriver driver;
  private String  existingEmail;
  private UserHomePageObject userHomePage  ;
  private UserRegisterPageObject userRegisterPage  ;
  private UserLoginPageObject userLoginPage;
  private UserCustomerInfoPageObject userCustomerInfoPage;
  UserDataMapper userData;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  userData = UserDataMapper.getUserData();
	  existingEmail = userData.getEmailAddress() + generateFakeNumber() + "@fakeemail.com";
	  
  }
  
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Open Register page");
	  userRegisterPage = userHomePage.clickToRegisterLink();
	  
	  userRegisterPage.clickToRadioButtonByLabel(driver,"Female");
	  	
	  log.info("Register - Step 02: Enter to Firstname textbox with value '" + userData.getFirstName() + "'");
	  userRegisterPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value '" + userData.getLastName() + "'");
	  userRegisterPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
	  
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthDay",userData.getDate());
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthMonth",userData.getMonth());
	  userRegisterPage.selectToDropdownByName(driver,"DateOfBirthYear",userData.getYear());
	  
	  log.info("Register - Step 04: Enter to Email textbox with value '" + existingEmail + "'");
	  userRegisterPage.inputToTextboxByID(driver, "Email", existingEmail);
	  
	  userRegisterPage.clickToCheckboxByLabel(driver,"Newsletter");
	  
	  log.info("Register - Step 05: Enter to Password textbox with value '" + userData.getPassword() + "'");
	  userRegisterPage.inputToTextboxByID(driver, "Password", userData.getPassword());
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value '" + userData.getPassword() + "'");
	  userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword",userData.getPassword());
	  
	  log.info("Register - Step 07: Click to 'Register' button");
	  userRegisterPage.clickToButtonByText(driver, "Register");
	  
	  log.info("Register - Step 08: Verify resiger success message is displayed");
	  Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	  
//	  log.info("Register - Step 09: Click to Logout link");
//	  userHomePage = userRegisterPage.clickToLogoutLink();
//	  
  }
  
  @Test
  public void User_02_Login() {
	  log.info("Login - Step 01: Navifate to Login page");
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '"+ existingEmail +"'");
	  userLoginPage.inputToTextboxByID(driver,"Email",existingEmail);	
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '"+ userData.getPassword() +"'");
	  userLoginPage.inputToTextboxByID(driver,"Password",userData.getPassword());	
	  
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
	  Assert.assertEquals(userCustomerInfoPage.getTextboxValueByID(driver,"FirstName"), userData.getFirstName());
	  
	  log.info("My Account - Step 4: Verify 'Last Name' value is correctly");
	  Assert.assertEquals(userCustomerInfoPage.getTextboxValueByID(driver,"LastName"), userData.getLastName());
	  
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
