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
	SearchResultsPage searchPage;
	ProductDisplayPage pdpPage;
	MyAccountPage myAccPage;
	CartPage cartPage;
	SitemapPage sitePage;
	@BeforeMethod(groups = {"Sanity","Regression","Master"})
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
		searchPage = new SearchResultsPage(driver);
		String expHeader = searchPage.verifyResultsHeader();

		Assert.assertEquals(expHeader, "Search - iMac");

	}

	@Test(priority = 2,groups = {"Sanity","Regression","Master"})
	public void verifyNavigationFromShoppingcartHeaderLink() {
		searchPage.clickiMacAddToCartBtn();
		homePage.clickshoppingcartHeaderLink();
		cartPage = new CartPage(driver);
		

		if (driver.getTitle().equals("Shopping Cart")) {
			Assert.assertEquals(cartPage.isShoppingCartProductImageDisplayed(), true);
			Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
			cartPage.clickRemoveBtn();
		} else {
			Assert.fail();
		}
	}
	@Test(priority = 3,groups = {"Sanity","Regression","Master"})
	public void verifyNavigationFromFooterSitemap() {
		searchPage.clickiMacAddToCartBtn();
		sitePage = new SitemapPage(driver);
		homePage.clicksitemapFooterLink();

		if (driver.getTitle().equals("Site Map")) {
			sitePage.clickshoppingcartLink();

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


	@AfterMethod(groups = {"Sanity","Regression","Master"})
	public void logoutTest() {
		try {
			homePage.clickMyAccount();
			myAccPage = new MyAccountPage(driver);
			myAccPage.clickLogout();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "is caused");
		}

	}

}
