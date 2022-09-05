package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.HomePageObjectUpload;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Upload_Files extends BaseTest {
  private WebDriver driver;
  private HomePageObjectUpload homePageObject;
  
  String file1 = "53E.png";
  String file2 = "Screenshot_1.png";
  String file3 = "Untitled-208.jpg";
  String[] multipleFileNames = {file1,file2,file3};
    
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  homePageObject = PageGeneratorManager.getHomePageUpload(driver);
	  
  }
  
  @Test
  public void Table_01_UploadFile() {
	
	  homePageObject.uploadMutipleFiles(driver, file1);
	  Assert.assertTrue(homePageObject.isFileLoadedByName(file1));
	  homePageObject.clickToStartButton();
	  Assert.assertTrue(homePageObject.isFileLinkUploadedByName(file1));
	  Assert.assertTrue(homePageObject.isFileImageUploadedByName(file1));
	  
  }
 
  @Test
  public void Table_02_Upload_MultipleFiles() {
	  homePageObject.uploadMutipleFiles(driver, multipleFileNames);
	  
	  Assert.assertTrue(homePageObject.isFileLoadedByName(file1));
	  Assert.assertTrue(homePageObject.isFileLoadedByName(file2));
	  Assert.assertTrue(homePageObject.isFileLoadedByName(file3));
	  
	  homePageObject.clickToStartButton();
	  
	  Assert.assertTrue(homePageObject.isFileLinkUploadedByName(file1));
	  Assert.assertTrue(homePageObject.isFileLinkUploadedByName(file2));
	  Assert.assertTrue(homePageObject.isFileLinkUploadedByName(file3));
	  
	  Assert.assertTrue(homePageObject.isFileImageUploadedByName(file1));
	  Assert.assertTrue(homePageObject.isFileImageUploadedByName(file2));
	  Assert.assertTrue(homePageObject.isFileImageUploadedByName(file3));

  }
  
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
}
