package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;

	@Test(priority = 1)
	public void verifyValidProductSearchTest() {
		logger.info("***** Starting TC004_Searchtest *****");
		try {
			// HomePage
			hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			hp.enterProductName();
			hp.clickSearchButton();

			sp = new SearchResultsPage(driver);
			String expHeader = sp.verifyResultsHeader();
			boolean iMacImgExp = sp.isiMacDisplayed();
			boolean iMacnNameExp = sp.isiMacNameDisplayed();

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
			hp.clearSearchBar();
			hp.enterInvalidProductName();
			hp.clickSearchButton();

			boolean searchResultsExp = sp.isNoSearchResultsDisplayed();

			Assert.assertEquals(searchResultsExp, true);
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail("Test Case is failed");
		}

	}

	@Test(priority = 3)
	public void verifyEmptyProductSearchTest() {
		try {
			hp.clearSearchBar();
			hp.clickSearchButton();

			boolean searchResultsExp = sp.isNoSearchResultsDisplayed();
			Assert.assertEquals(searchResultsExp, true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Case is failed");
		}
	}
}
