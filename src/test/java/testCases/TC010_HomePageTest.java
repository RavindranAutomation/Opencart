package testCases;


import org.testng.Assert;
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

public class TC010_HomePageTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;
	ProductDisplayPage pdpPage;
	MyAccountPage myAccPage;
	CartPage cartPage;
	SitemapPage sitePage;
	@BeforeMethod
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

	}

	@Test
	public void verify_Homepage_navigation_from_shoppingcart() {
		searchPage = new SearchResultsPage(driver);
		cartPage = new CartPage(driver);
		try {
			searchPage.clickiMacAddToCartBtn();
			homePage.clickshoppingcartHeaderLink();
			Thread.sleep(2000);
			cartPage.clickcontinueShoppingBtn();
			Assert.assertEquals(driver.getTitle(),"Your Store");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}



	}

}
