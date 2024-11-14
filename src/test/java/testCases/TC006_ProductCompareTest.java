package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC006_ProductCompareTest extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;
	ProductComparisonPage pdpPage;

	@Test(groups = { "Regression", "Master" })
	public void verifyProductCompareWith() {
		// Login
			homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();

			loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("email"));
			loginPage.setPassword(p.getProperty("password"));
			loginPage.clickLogin();

			homePage.enterProductName();
			homePage.clickSearchButton();

			searchPage = new SearchResultsPage(driver);
			searchPage.clickImacCompareBtn();
			searchPage.clickProductComparisonLink();

			pdpPage = new ProductComparisonPage(driver);
		
		
		Assert.assertEquals(pdpPage.verifyProductComParisonHeader(), true);

		Assert.assertEquals(pdpPage.verifyImacProductId(), "Product 14");

		Assert.assertEquals(pdpPage.verifyImacProductName(), "iMac");

		pdpPage.clickRemoveBtn();

		if (pdpPage.verifyproductRemovedSuccessMessage()
				.contains("Success: You have modified your product comparison!")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	} 

}


