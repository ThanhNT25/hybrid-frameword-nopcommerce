package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_DataTable_DataGrid_II extends BaseTest {
  private WebDriver driver;
  private HomePageObject homePageObject;
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  homePageObject = PageGeneratorManager.getHomePage(driver);
	  
  }
  
  
  @Test
  public void Table_01_Enter_To_Textbox_At_Any_Row() {
	  homePageObject.clickToLoadButton();
	  
	  homePageObject.enterToTextboxByColumnNameAtRowNumber("Album","1","Michale");
	  homePageObject.sleepInSecond(2);
	  
	  homePageObject.enterToTextboxByColumnNameAtRowNumber("Artist","4","Michale Jacksons");
	  homePageObject.sleepInSecond(2);
	  
	  homePageObject.selectDropdownColumnNameAtRowNumber("Origin","1","Japan");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.selectDropdownColumnNameAtRowNumber("Origin","1","US");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.checkToCheckboxByColumnNameAtRow("With Poster?","1");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.checkToCheckboxByColumnNameAtRow("With Poster?","2");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.uncheckToCheckboxByColumnNameAtRow("With Poster?","1");
	  homePageObject.sleepInSecond(3);
	  
	  homePageObject.clickToIconByRowNumber("1", "Remove Current Row");
	  
	  homePageObject.clickToIconByRowNumber("1", "Insert Row Above");
	  
	  homePageObject.clickToIconByRowNumber("3", "Move Up");
	  
	  homePageObject.clickToIconByRowNumber("3", "Move Down");
	  
	  homePageObject.clickToIconByRowNumber("5","Remove Current Row");

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
}
