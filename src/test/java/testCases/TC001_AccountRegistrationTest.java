package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	AccountRegistrationPage accRegPage;
	HomePage homePage;
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
			homePage = new HomePage(driver);
		homePage.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		homePage.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		accRegPage = new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
		accRegPage.setFirstName(randomeString().toUpperCase());
		accRegPage.setLastName(randomeString().toUpperCase());
		accRegPage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		accRegPage.setTelephone(randomeNumber());
			
		String password=randomeAlphaNumberic();
			
		accRegPage.setPassword(password);
		accRegPage.setConfirmPassword(password);
		
		accRegPage.setPrivacyPolicy();
		accRegPage.clickContinue();
		
		logger.info("Validating expected message..");
		
		String confmsg = accRegPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
	}
	
	
	
	
}
