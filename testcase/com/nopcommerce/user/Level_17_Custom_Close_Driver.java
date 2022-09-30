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
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_17_Custom_Close_Driver extends BaseTest {
  private WebDriver driver;
  private String  emailAddress;
  private String firstName, lastName, correctPassword, confirmPassword;
  private UserHomePageObject userHomePage  ;
  private UserRegisterPageObject userRegisterPage  ;
  private UserLoginPageObject userLoginPage;
  private UserCustomerInfoPageObject userCustomerInfoPage;
  private UserAddressPageObject userAddressPage;
  private UserMyProductReviewPageObject userMyProductReviewPage;
  private UserRewardPointPageObject userRewardPointPage;
  public static Set<Cookie> LoggedCookies;

    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	    emailAddress = "auto" + generateNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		correctPassword = "123456";
		confirmPassword = "123456";

		log.info("Pre-Condition - Step 01: Open Register page");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Enter to LastName textbox with value '" + lastName + "'");
		userRegisterPage.inputToLastnameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Enter to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 05: Enter to Password textbox with value '" + correctPassword + "'");
		userRegisterPage.inputToPasswordTextbox(correctPassword);

		log.info("Pre-Condition - Step 06: Enter to Confirm Password textbox with value '" + confirmPassword + "'");
		userRegisterPage.inputToConfirmPasswordTextbox(confirmPassword);

		log.info("Pre-Condition - Step 07: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify resiger success message is displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed..");

		log.info("Pre-Condition - Step 09: Click to Logout link");
		userHomePage = userRegisterPage.clickToLogoutLink();
		
		log.info("Pre-Condition - Step 10: Navifate to Login page"); userLoginPage =
		userHomePage.clickToLoginLink();
		 
		log.info("Pre-Condition - Step 11: Enter to Email textbox with value is '"+
		emailAddress +"'"); userLoginPage.inputToEmailTextbox(emailAddress);
		  
		log.info("Pre-Condition - Step 12: Enter to Password textbox with value is '"
		+ correctPassword +"'");
		userLoginPage.inputToPasswordTextbox(correctPassword);
		
		log.info("Pre-Condition - Step 13: Click to Login button"); userHomePage =
		userLoginPage.clickToLoginButton();
		
		LoggedCookies = userHomePage.getAllCookies(driver);
		for(Cookie cookie : LoggedCookies) {
			System.out.println("Cookie at Common Class : "+ cookie);
		}
	  
  }
  
  @Test
  public void User_01_Register() {
	 

  }
  
  @Test
  public void User_02_Login() {
	  
  }
  
  
  @Test
  public void User_03_Switch_Page() {
	  
  }
  
  @Test
  public void User_04_Dynamic_Page_01() {
	  
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
