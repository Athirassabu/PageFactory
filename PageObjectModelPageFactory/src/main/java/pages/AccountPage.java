package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class AccountPage extends BaseMethods {
	
	public AccountPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//div[@title='New']") WebElement clkNew;
			//click new
			public AccountPage clickNew() {

				clkNew.click();
				return this;

			}
			
			@FindBy(how=How.XPATH,using="//input[@class=' input']") WebElement enterNme;
			// enter value in text field
			public AccountPage enterName(String Nme) {

				enterNme.sendKeys(Nme);
				return this;

			}
			
			@FindBy(how=How.XPATH,using="(//a[@class='select'])[3]") WebElement dropClick;
			@FindBy(how=How.XPATH,using="//a[@title='Public']") WebElement dropSelect;

			// Drop down select public
			public AccountPage dropDownSelect() {
				
				dropClick.click();
				dropSelect.click();
				return this;
			}
			@FindBy(how=How.XPATH,using="//button[@title='Save']/span") WebElement clickSave;
			//Click save
			public VerifyAccountPage clickSave() {

				clickSave.click();
				return new VerifyAccountPage(driver);

			}
			@FindBy(how=How.XPATH,using="//input[@name='Account-search-input']") WebElement searchField;
		//Search account
			public AccountPage searchAccount(String Nme) throws InterruptedException {

				//WebElement search = driver.findElementByXPath("//input[@name='Account-search-input']");
				searchField.sendKeys(Nme);
				searchField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				return this;

			}
			@FindBy(how=How.XPATH,using="//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[6]/span[1]/div[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]") WebElement clickEdit;
			@FindBy(how=How.XPATH,using="//a[@title='Edit']") WebElement selectEdit;
          //click edit
			public AccountPage clickEdit() {

				clickEdit.click();
				System.out.println("drop down clicked");
				selectEdit.click();
				return this;
				

			}
			//click delete
			public VerifyAccountDelete clickDelete() {

				driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[6]/span[1]/div[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]").click();
				driver.findElementByXPath("//a[@title='Delete']").click();
				driver.findElementByXPath("//span[text()='Delete']").click();
				return new VerifyAccountDelete(driver);
			}
			//fill details
			public AccountPage enterDetails(String  billAdd,String shippAdd,String phone) {

				driver.findElementByXPath("(//a[@class='select'])[2]").click();
				driver.findElementByXPath("//a[@title='Technology Partner']").click();
				driver.findElementByXPath("(//a[@class='select'])[4]").click();
				driver.findElementByXPath("//a[@title='Healthcare']").click();
				driver.findElementByXPath("//textarea[@placeholder='Billing Street']").sendKeys(billAdd);
				driver.findElementByXPath("//textarea[@placeholder='Shipping Street']").sendKeys(shippAdd);
				driver.findElementByXPath("(//a[@class='select'])[5]").click();
				driver.findElementByXPath("//a[@title='Low']").click();
				driver.findElementByXPath("(//a[@class='select'])[6]").click();
				driver.findElementByXPath("//a[@title='Silver']").click();
				driver.findElementByXPath("(//a[@class='select'])[8]").click();
				driver.findElementByXPath("//a[@title='No']").click();
				driver.findElementByXPath(" (//input[@class=' input'])[2]").sendKeys(phone);
				driver.findElementByXPath("(//a[@class='select'])[7]").click();
				driver.findElementByXPath("(//a[@title='No'])[2]").click();
				return this;
				
				

			}
			
			@FindBy(how=How.XPATH,using="//button[@title='Save']/span") WebElement clickSaveEdit;
			//click save
			public VerifyAccountEditPage clickSaveEdit() throws InterruptedException {
                Thread.sleep(3000);
                clickSaveEdit.click();
				return new VerifyAccountEditPage(driver);

			}
		
			
			

}
