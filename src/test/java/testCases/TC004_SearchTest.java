package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultsPage searchPage;

	@Test(priority = 1,groups = {"Sanity","Regression","Master"})
	public void verifyValidProductSearchTest() {
		logger.info("***** Starting TC004_Searchtest *****");
		try {
			// HomePage
			
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

			searchPage = new SearchResultsPage(driver);
			
			String expHeader = searchPage.verifyResultsHeader();
			boolean iMacImgExp = searchPage.isiMacDisplayed();
			boolean iMacnNameExp = searchPage.isiMacNameDisplayed();

			if (expHeader.equals("Search - iMac")) {

				if (iMacImgExp == true) {

					if (iMacnNameExp == true) {

						Assert.assertTrue(true);

					}

				}

			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test(priority = 2)
	public void verifyInvalidProductSearchTest() {

		try {
			homePage.clearSearchBar();
			homePage.enterInvalidProductName();
			homePage.clickSearchButton();

			boolean searchResultsExp = searchPage.isNoSearchResultsDisplayed();

			Assert.assertEquals(searchResultsExp, true);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail("Test Case is failed");
		}

	}

	@Test(priority = 3)
	public void verifyEmptyProductSearchTest() {
		try {
			homePage.clearSearchBar();
			homePage.clickSearchButton();

			boolean searchResultsExp = searchPage.isNoSearchResultsDisplayed();
			Assert.assertEquals(searchResultsExp, true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Case is failed");
		}
	}
}
