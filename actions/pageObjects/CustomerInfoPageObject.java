package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplay() {
		waitForElementClickable(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		clickToElement(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return true;
	}


}
