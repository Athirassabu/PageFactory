package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;
import utility.Screenshot;


public class HomePage extends BaseMethods {
	
	public HomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	// click sales
	// Click toggle
	@FindBy(how=How.CLASS_NAME,using="slds-icon-waffle") WebElement clkToggle;
	public HomePage clickToggle() {
		
		clkToggle.click();

		//driver.findElementByClassName(prop.getProperty("HomePage.Toggle.ClassName")).click();
		return this;

	}

	// click view all
	@FindBy(how=How.XPATH,using="//button[@class='slds-button']") WebElement clkViewAll;
	public HomePage clickViewAll() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(clkViewAll));
		clkViewAll.click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.clickViewAll.Xpath"))));
	//	driver.findElementByXPath(prop.getProperty("HomePage.clickViewAll.Xpath")).click();
		
		Screenshot.captureScreenshot(driver, "View all");
		return this;

	}

	// action click
	@FindBy(how=How.XPATH,using="//p[text()='Sales']") WebElement clkSales;
	public SalesPage clickSales() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(clkSales));
		clkSales.click();
		
		return new SalesPage(driver);

	}
}
