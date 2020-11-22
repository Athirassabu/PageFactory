package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadExcel;


public class BaseMethods {
	
	
	public RemoteWebDriver driver;
	public String excelName;
	public Properties prop;
	@BeforeMethod
	@Parameters({"browser","username","password"})
	public void setup(String browser,String uName,String pwd) throws Exception{
		
		/*
		 * //Properties file setup FileInputStream fis=new
		 * FileInputStream("./src/main/resources/"+lang+".properties"); prop=new
		 * Properties(); prop.load(fis);
		 */
		
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("Firefox")){
		//create firefox instance
			
			WebDriverManager.firefoxdriver().setup();
			//Browser notification
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			 driver = new FirefoxDriver(options);
			
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			// Disable browser notification
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
		}
		
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(uName);
		driver.findElementById("password").sendKeys(pwd);
		driver.findElementById("Login").click();
	}
	

	
	  @DataProvider(name="fetchData")
	  public String[][] sendData() throws IOException {
		  return ReadExcel.excelData(excelName);
	  
	  }
	 
	
	
	  @AfterMethod 
	  public void closeBrowser() {
	  
	  driver.quit();
	  
	  }
	  
	 
}


