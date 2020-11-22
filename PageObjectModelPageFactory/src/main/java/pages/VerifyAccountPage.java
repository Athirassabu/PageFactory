package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

import base.BaseMethods;
import utility.Screenshot;

public class VerifyAccountPage extends BaseMethods {

	public VerifyAccountPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//@FindBy(how=How.XPATH,using="//span[@class='toastMessage slds-text-heading--small forceActionsText']") WebElement verifyAccnt;

	public VerifyAccountPage verifyCreateAccount(String name) throws InterruptedException {

		
		
		Thread.sleep(3000);
		WebElement element1 = driver
				.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
		String displayedValue = element1.getText();
		System.out.println(displayedValue);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(displayedValue,name);
		Screenshot.captureScreenshot(driver, "Create account");
		return this;

	}
}
