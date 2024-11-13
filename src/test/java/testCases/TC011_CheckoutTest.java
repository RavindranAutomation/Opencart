package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.SitemapPage;
import testBase.BaseClass;

public class TC011_CheckoutTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;
	ProductDisplayPage pdpPage;
	MyAccountPage myAccPage;
	CartPage cartPage;
	SitemapPage sitePage;
	CheckoutPage checkoutPage;

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
	public void verify_CheckOut_With_ExistingAddress() {
		try {
			searchPage = new SearchResultsPage(driver);
			cartPage = new CartPage(driver);
			checkoutPage = new CheckoutPage(driver);
			searchPage.clickiMacAddToCartBtn();
			homePage.clickshoppingcartHeaderLink();
			cartPage.clickcheckoutBtn();

			checkoutPage.clickBillingContinueBtn();
			checkoutPage.clickshippingContinueBtn();

			checkoutPage.enterComments();
			checkoutPage.clickDeliveryContinueBtn();
			checkoutPage.checkTerms();
			checkoutPage.clickPaymentContinue();
		} catch (Exception e) {
			Assert.fail(e + "Caused");
			e.printStackTrace();
		}

		System.out.println(checkoutPage.getOrderdProductID());
		System.out.println(checkoutPage.getOrderTotal());

	}

}
