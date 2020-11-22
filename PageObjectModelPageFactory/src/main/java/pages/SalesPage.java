package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BaseMethods;

public class SalesPage extends BaseMethods {
	
	public SalesPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH,using="//span[text()='Accounts']") WebElement clkAccnt;
	//click account
	public AccountPage clickAccount() {
		
		

		//WebElement element = driver.findElementByXPath("//span[text()='Accounts']");
		driver.executeScript("arguments[0].click();", clkAccnt);
		return new AccountPage(driver);

	}


}
