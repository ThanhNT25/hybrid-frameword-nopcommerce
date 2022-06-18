package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object {
  private WebDriver driver;
  private String emailAddress;
  private String projectPath = System.getProperty("user.dir");
  private String firstName, lastName, password, confirmPassword;
  private HomePageObject homePage  ;
  private RegisterPageObject registerPage  ;
    
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://demo.nopcommerce.com/");
	  
	  homePage = new HomePageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  
	  //basePage = new BasePage();
	  emailAddress = "auto"+generateNumber()+"@gmail.com";
	  firstName = "Automation";
	  lastName = "FC";
	  password ="123456";
	  confirmPassword = "123456";
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page - Step 03: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox("emailAddress");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Register Page Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page Step 04: Verify messsage error displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Register Page Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register Page Step 04: Verify messsage register successfuly displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Register Page Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
	 
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Register Page Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	    
	  System.out.println("Register Page Step 04: Verify messsage error displayed");
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  System.out.println("Register Page Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
//	  Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	  System.out.println("Register Page Step 04: Verify messsage error displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");	 
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password() {
	  System.out.println("Home Page Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123456");
	  registerPage.inputToConfirmPasswordTextbox("123654");
	  
	  System.out.println("Register Page Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
//	  Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	  System.out.println("Register Page Step 04: Verify messsage error displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");	 	 
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
