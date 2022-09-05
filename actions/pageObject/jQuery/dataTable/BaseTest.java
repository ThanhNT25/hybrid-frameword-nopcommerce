package pageObject.jQuery.dataTable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.GlobalConstants;

public class BaseTest {

	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		 if(browserName.equals("firefox")) {
			  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			  driverBaseTest = new FirefoxDriver();
		  } else if  (browserName.equals("chrome")){ 
			  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			  driverBaseTest = new ChromeDriver();
		  } else {
			  throw new RuntimeException("Browser name invalid");
		  }
		 
		 //driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		 driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL_JQUERY_DATA_TABLE);
		 return driverBaseTest;
	}
	
}
