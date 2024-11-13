package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC005_ToolTipTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;

	@Test(groups = {"Regression","Master"})
	public void verifyAddToCartToolTipTextOfTheProduct() {
		logger.info("***** Starting TC005_ToolTipTest *****");
		homePage = new HomePage(driver);

		homePage.clickMyAccount();
		homePage.clickLogin();

		// Login
		loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();

		homePage.enterProductName();
		homePage.clickSearchButton();

		Assert.assertEquals(homePage.getAddtoWishListToolTip(), "Add to Wish List");
		Assert.assertEquals(homePage.getCompareProductToolTip(), "Compare this Product");


	}

}
