package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.AccountPage;
import pages.HomePage;
import pages.SalesPage;
import pages.VerifyAccountDelete;
import pages.VerifyAccountEditPage;

public class DeleteTest extends BaseMethods {
	@BeforeClass
	public void setFile()
	{
		excelName="create";
	}

	//,dependsOnMethods= {"testcases.CreateTest.Create,testcases.EditTest.Edit"}
	
	@Test(dataProvider="fetchData")
	public void Delete(String Name) throws InterruptedException
	{
		
		HomePage np=new HomePage(driver);
		np.clickToggle().clickViewAll().clickSales();
		SalesPage sp=new SalesPage(driver);
		sp.clickAccount();
		AccountPage ap=new AccountPage(driver);
		ap.searchAccount(Name).clickDelete();
		VerifyAccountDelete vad=new VerifyAccountDelete(driver);
		vad.verifyDeleteAccount(Name);
	}
}
