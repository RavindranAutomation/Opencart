package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccPage;

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Startign TC_002_LoginTest *****");
		
		try
		{
			
		BaseClass.login();
		
		myAccPage = new MyAccountPage(driver);
		boolean targetPage=myAccPage.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****** Finished TC_002_LoginTest *****");
	}
	
}
