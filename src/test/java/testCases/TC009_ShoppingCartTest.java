package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.SitemapPage;
import pageObjects.WishlistPage;
import testBase.BaseClass;

public class TC009_ShoppingCartTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchResultsPage;
	ProductDisplayPage pdp;
	MyAccountPage myAccPage;
	CartPage cartPage;
	WishlistPage wishPage;
	SitemapPage sitemapPage;

	@BeforeMethod
	public void loginTest() {
		try {
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

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e + "Exeception is caused hence TC failed");
		}
		searchResultsPage = new SearchResultsPage(driver);
		String expHeader = searchResultsPage.verifyResultsHeader();

		Assert.assertEquals(expHeader, "Search - iMac");

	}

	@Test(priority = 1)
	public void verifyNavigationFromSuccessMessage() {
		searchResultsPage.clickiMacAddToCartBtn();
		searchResultsPage.clickShoppingCartLink();
		cartPage = new CartPage(driver);

		if (cartPage.isShoppingSubHeaderMenuDisplayed() == true) {
			Assert.assertEquals(cartPage.isShoppingCartProductImageDisplayed(), true);
			Assert.assertEquals(driver.getTitle(), "Shopping Cart");
			Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
			cartPage.clickRemoveBtn();
		} else {
			Assert.fail();
		}

	}

	@Test(priority = 2)
	public void verifyNavigationFromShoppingcartHeaderLink() {
		searchResultsPage.clickiMacAddToCartBtn();
		homePage.clickshoppingcartHeaderLink();

		if (driver.getTitle().equals("Shopping Cart")) {
			Assert.assertEquals(cartPage.isShoppingCartProductImageDisplayed(), true);
			Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
			cartPage.clickRemoveBtn();
		} else {
			Assert.fail();
		}
	}
	@Test(priority = 3)
	public void verifyNavigationFromFooterSitemap() {
		searchResultsPage.clickiMacAddToCartBtn();
		homePage.clicksitemapFooterLink();
		cartPage = new CartPage(driver);

		if (driver.getTitle().equals("Site Map")) {
			sitemapPage = new SitemapPage(driver);
			sitemapPage.clickshoppingcartLink();

			if (driver.getTitle().equals("Shopping Cart")) {
				Assert.assertEquals(cartPage.isShoppingCartProductImageDisplayed(), true);
				Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
				cartPage.clickRemoveBtn();
			} 	
		}		
		else {
			Assert.fail();
		}
	}


	@AfterMethod
	public void logoutTest() {
		myAccPage = new MyAccountPage(driver);
		try {
			homePage.clickMyAccount();
			myAccPage.clickLogout();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "is caused");
		}

	}

}
