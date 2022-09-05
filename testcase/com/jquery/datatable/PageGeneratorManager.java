package com.jquery.datatable;

import org.openqa.selenium.WebDriver;

import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.uploadFile.HomePageObjectUpload;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static HomePageObjectUpload getHomePageUpload(WebDriver driver) {
		return new HomePageObjectUpload(driver);
	}

}
