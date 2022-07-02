package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class AddressPageObject extends BasePage {

	private WebDriver driver;
	
	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
