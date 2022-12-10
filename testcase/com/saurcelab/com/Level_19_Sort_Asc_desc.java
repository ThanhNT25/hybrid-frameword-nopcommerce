package com.saurcelab.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.saurcelab.LoginPageObject;
import pageObject.saurcelab.ProductPageObject;

public class Level_19_Sort_Asc_desc extends BaseTest {
	WebDriver driver;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String saurcelabUrl) {
		  driver = getBrowserDriver(browserName, saurcelabUrl);
		  loginPage = pageObject.saurcelab.PageGeneratorManager.getLoginPage(driver);
		  
		  loginPage.enterToUsernameTextbox("standard_user");
		  loginPage.enterToPasswordTexbox("secret_sauce");
		  productPage = loginPage.clickToLoginButton();
		  	  
	  }
	LoginPageObject loginPage;
	ProductPageObject productPage;
	  
	@Test
	public void Sort_01_Name() {
		//Asceding
		productPage.selectItemProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(3);
		
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		//Descending
		productPage.selectItemProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(3);
		
		Assert.assertTrue(productPage.isProductNameSortByDescending());
		
	}
	
	@Test
	public void Sort_02_Price() {
		//Asceding
		productPage.selectItemProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(3);
		
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		
		//Desceding
		productPage.selectItemProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(3);
		
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
	

}
