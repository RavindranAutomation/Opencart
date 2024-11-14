package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC007_PDPTest extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;
	ProductDisplayPage pdpPage;
	MyAccountPage myAccPage;

	@BeforeMethod(groups = { "Sanity", "Regression", "Master" })
	public void loginTest() {

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
		Assert.assertEquals(expHeader, "Search - iMac");

		if (searchPage.verifyProductTile() == true) {
			searchPage.clickImacImg();
			Assert.assertTrue(true);
		}

		Assert.assertEquals(driver.getTitle(), "iMac");

	}

	@Test(priority = 1, groups = { "Sanity", "Regression", "Master" })
	public void verifyPDPThumnails() throws AWTException, InterruptedException {
		pdpPage = new ProductDisplayPage(driver);

		if (pdpPage.verifyThumbnail() == true) {
			pdpPage.clickImacThumbnailImg();
			pdpPage.clickNextArrowButton();
			Assert.assertTrue(true);

		}

		if (pdpPage.verifyImacSideView() == true) {
			pdpPage.clickiMacSideView();
			Assert.assertTrue(true);

			if (pdpPage.verifyiMacTiltView() == true) {
				pdpPage.clickiMacTiltVieww();
				Assert.assertTrue(true);
			}

		} else {
			Assert.fail();
		}

	}

	@Test(priority = 2, groups = { "Sanity", "Regression", "Master" })
	public void verifyProductDetails() {

		Assert.assertEquals(pdpPage.getProductName(), "iMac");
		Assert.assertEquals(pdpPage.getProductBrand(), "Apple");
		Assert.assertEquals(pdpPage.getProductCode(), "Product Code: Product 14");

		Assert.assertEquals(pdpPage.getProductAvailability(), "Availability: In Stock");

		Assert.assertEquals(pdpPage.getProductPrice(), "$100.00");
		Assert.assertEquals(pdpPage.getDefaultQty(), "1");
		Assert.assertEquals(pdpPage.getProductDescription(),
				"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo processors. And more memory standard. "
						+ "Combine this with Mac OS X Leopard and iLife ´08, and it´s more all-in-one than ever. "
						+ "iMac packs amazing performance into a stunningly slim space.");

	}

	@AfterMethod(groups = { "Sanity", "Regression", "Master" })
	public void logoutTest() {

		try {
			myAccPage = new MyAccountPage(driver);
			homePage.clickMyAccount();
			myAccPage.clickLogout();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "is caused");
		}

	}

}
