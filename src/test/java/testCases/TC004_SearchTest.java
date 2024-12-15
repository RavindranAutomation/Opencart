package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	SearchResultsPage searchPage;
	MyAccountPage myAccPage;

	@BeforeMethod(groups = { "Sanity", "Regression", "Master" })
	public void loginTest() {
		BaseClass.login();

	}

	@Test(priority = 1, groups = { "Sanity", "Regression", "Master" })
	public void verifyValidProductSearchTest() {
		logger.info("***** Starting TC004_Searchtest *****");
		homePage = new HomePage(driver);
		homePage.enterProductName();
		homePage.clickSearchButton();
		searchPage = new SearchResultsPage(driver);



		String expHeader = searchPage.verifyResultsHeader();
		boolean iMacImgExp = searchPage.isiMacDisplayed();
		boolean iMacnNameExp = searchPage.isiMacNameDisplayed();

		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(expHeader, "Search - iMac");

		//Assert.assertEquals(expHeader, "Search - iMac");
		Assert.assertEquals(iMacImgExp, true);
		Assert.assertEquals(iMacnNameExp, true);
	}

	@Test(priority = 2)
	public void verifyInvalidProductSearchTest() {

		homePage.enterInvalidProductName();
		homePage.clickSearchButton();

		boolean searchResultsExp = searchPage.isNoSearchResultsDisplayed();
		Assert.assertEquals(searchResultsExp, true);

	}

	@AfterMethod(groups = { "Sanity", "Regression", "Master" })
	public void logoutTest() {

		myAccPage = new MyAccountPage(driver);
		homePage.clickMyAccount();
		myAccPage = new MyAccountPage(driver);
		myAccPage.clickLogout();

		logger.info("***** Ended TC004_Searchtest *****");
	}

}
