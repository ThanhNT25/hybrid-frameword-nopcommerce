package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {

	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		 if(browserName.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			  driverBaseTest = new FirefoxDriver();
		  } else if (browserName.equals("h_firefox")) {
			  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			  FirefoxOptions options = new FirefoxOptions();
			  options.addArguments(".headless");
			  options.addArguments("window-size-1920x1080");
			  driverBaseTest = new FirefoxDriver(options);
			  
		  } else if  (browserName.equals("chrome")){ 
			  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			  driverBaseTest = new ChromeDriver();
			  
		  } else if  (browserName.equals("h_chrome")){ 
			  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--headless");
			  options.addArguments("window-size-1920x1080");
			  driverBaseTest = new ChromeDriver();
			  
		  } else if  (browserName.equals("edge")){ 
			  System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			  driverBaseTest = new EdgeDriver();
			  
		  }  else if  (browserName.equals("opera")){ 
			  System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			  driverBaseTest = new OperaDriver();
		  } else {
			  throw new RuntimeException("Browser name invalid");
		  }
		 
		 driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL_JQUERY_UPLOAD_FILE);
		 driverBaseTest.manage().window().maximize();
		 return driverBaseTest;
	}
	
}
