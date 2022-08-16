package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_DataTable_DataGrid extends BaseTest {
  private WebDriver driver;
  private HomePageObject homePageObject;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  homePageObject = PageGeneratorManager.getHomePage(driver);
	  
  }
  
 
  public void Table_01() {
	  homePageObject.openPagingByNumber("10");
	  homePageObject.sleepInSecond(1);
	  Assert.assertTrue(homePageObject.isPageNumberActived("10"));
	  
	  homePageObject.openPagingByNumber("7");
	  homePageObject.sleepInSecond(1);
	  Assert.assertTrue(homePageObject.isPageNumberActived("7"));
	  
	  homePageObject.openPagingByNumber("3");
	  homePageObject.sleepInSecond(1);
	  Assert.assertTrue(homePageObject.isPageNumberActived("3"));
	  
  }
  
  
  
  public void Table_02_Enter_To_Header() {
	  homePageObject.refreshPage(driver);
	  
	  homePageObject.enterToHeaderTextboxByLabel("Country","Argentina");
	  homePageObject.enterToHeaderTextboxByLabel("Females","338282");
	  homePageObject.enterToHeaderTextboxByLabel("Males","349238");
	  homePageObject.enterToHeaderTextboxByLabel("Total","687522");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.enterToHeaderTextboxByLabel("Country","Angola");
	  homePageObject.enterToHeaderTextboxByLabel("Females","276880");
	  homePageObject.enterToHeaderTextboxByLabel("Males","276472");
	  homePageObject.enterToHeaderTextboxByLabel("Total","553353");
	  homePageObject.sleepInSecond(3);

  }
  
  @Test
  public void Table_03_Get_All_Row() {
	  homePageObject.refreshPage(driver);
	  homePageObject.getValueEachRowAtAllPage();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
}
