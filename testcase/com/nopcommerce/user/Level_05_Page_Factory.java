package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Page_Factory extends BaseTest{
  private WebDriver driver;
  private String invalidEmail, existingEmail, notFoundEmail;
  private String firstName, lastName, correctPassword, incorrectPassword, confirmPassword;
  private HomePageObject homePage  ;
  private RegisterPageObject registerPage  ;
  private LoginPageObject loginPage;
    
  @Parameters("browser")  
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver  = getBrowserDriver(browserName);
	  driver.get("https://demo.nopcommerce.com/");
	  homePage = new HomePageObject(driver);
	  
	  //basePage = new BasePage();
	  existingEmail = "auto"+generateNumber()+"@gmail.com";
	  notFoundEmail = "auto"+generateNumber()+"@gmail.vn";
	  invalidEmail = "abc";
	  firstName = "Automation";
	  lastName = "FC";
	  correctPassword ="123456";
	  incorrectPassword = "09876654";
	  confirmPassword = "123456";
	  
	  System.out.println("Pre - Condition Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  registerPage = new RegisterPageObject(driver);
	  
	  System.out.println("Pre - Condition Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(correctPassword);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Pre - Condition Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Pre - Condition Step 04: Verify messsage register successfuly displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Pre - Condition Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
	  
	  homePage = new HomePageObject(driver);
  }
  
  @Test
  public void Login_01_Empty_Data() {
	  System.out.println("Login_01 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  	  
	  System.out.println("Login_01 Step 02: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_01 - Step 03: Verify error message displayed");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  System.out.println("Login_02 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  System.out.println("Login_02 Step 02: Input invalid email to Email Textbox");
	  loginPage.inputToEmailTextbox(invalidEmail);	
	  
	  System.out.println("Login_02 Step 03: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_02 Step 04: Verify messsage error displayed");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  
  @Test
  public void Login_03_Email_Not_Found() {
	  System.out.println("Login_03 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  System.out.println("Login_03 Step 02: Input email not found to Email Textbox");
	  loginPage.inputToEmailTextbox(notFoundEmail);	
	  
	  System.out.println("Login_03 Step 03: Input password to password Textbox");
	  loginPage.inputToPasswordTextbox(incorrectPassword);	
	  
	  System.out.println("Login_04 Step 04: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_04 Step 05: Verify messsage Login unsuccess");
	  Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  	 
  }
  
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  System.out.println("Login_04 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  System.out.println("Login_04 Step 02: Input email existing to Email Textbox");
	  loginPage.inputToEmailTextbox(existingEmail);	
	  
	  System.out.println("Login_04 Step 03: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_04 Step 04: Verify messsage Login unsuccess");
	  Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void Login_05_Existing_Email_Incorrect_Password() {
	  System.out.println("Login_04 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  System.out.println("Login_04 Step 02: Input email existing to Email Textbox");
	  loginPage.inputToEmailTextbox(existingEmail);	
	  
	  System.out.println("Login_04 Step 03: Input invalid password correct to Password Textbox");
	  loginPage.inputToPasswordTextbox(incorrectPassword);	
	  
	  System.out.println("Login_04 Step 04: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_04 Step 05: Verify messsage Login unsuccess");
	  Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void Login_06_Existing_Email_Correct_Password() {
	  System.out.println("Login_04 Step 01: Click to Login link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  	  
	  System.out.println("Login_04 Step 02: Input email existing to Email Textbox");
	  loginPage.inputToEmailTextbox(existingEmail);	
	  
	  System.out.println("Login_04 Step 03: Input invalid password correct to Password Textbox");
	  loginPage.inputToPasswordTextbox(correctPassword);	
	  
	  System.out.println("Login_04 Step 04: Click to LOGIN button");
	  loginPage.clickToLoginButton();
	  
	  homePage = new HomePageObject(driver);
	  
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
