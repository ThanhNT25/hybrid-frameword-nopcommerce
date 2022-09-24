package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Verify_Element_Display() {
		loginPage.clickToCreateNewAccountButton();
		loginPage.enterToEmailAddressTextbox("automation@gmail.com");
		loginPage.sleepInSecond(3);
		VerifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
	}
	
	@Test
	public void TC_02_Verify_Element_UnDisplay_In_Dom() {
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		
		VerifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
		
	}
	
	@Test
	public void TC_03_Verify_Element_UnDisplay_Not_In_Dom() {
		loginPage.clickToCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);
		
		VerifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
		
	}
	
	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
