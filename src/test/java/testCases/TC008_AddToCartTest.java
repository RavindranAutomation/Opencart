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
import pageObjects.WishlistPage;
import testBase.BaseClass;

public class TC008_AddToCartTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchResultsPage;
	ProductDisplayPage pdp;
	MyAccountPage myAccPage;
	CartPage cartPage;
	WishlistPage wishPage;

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
	public void verifyAddtoCartFromSearchResultsPage() {
		

		cartPage = new CartPage(driver);

		try {
			searchResultsPage.clickiMacAddToCartBtn();

			if (searchResultsPage.verifyCompareSuccessMessage() == true) {
				searchResultsPage.clickShoppingCartLink();

				if (cartPage.isShoppingCartProductImageDisplayed() == true) {
					cartPage.clickRemoveBtn();
					Assert.assertEquals(driver.getTitle(), "Shopping Cart");
					Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
				}

			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "test Case is Failed");
		}

	}
	@Test(priority = 2)
	public void verifyAddtoCartFromWishlistPage() {
		searchResultsPage.clickWishlistButton();
		Assert.assertEquals(searchResultsPage.iswishListSuccessMessageDisplayed(), true);
		searchResultsPage.clickWishlistLink();
		
		wishPage = new WishlistPage(driver);
		
		
		if (wishPage.isWishlistSubmenuDisplayed()) {
			
			wishPage.clickwishlistAddToCartBtn();
			Assert.assertTrue(true);
			if (wishPage.iswishlistToCartSuccessMessageDisplayed()) {
				wishPage.clickwishlistShoppingcartLink();
				Assert.assertTrue(true);
				
			}else {
				Assert.fail();
			}
			
		}
		
		if (cartPage.isShoppingCartProductImageDisplayed() == true) {
			Assert.assertEquals(driver.getTitle(), "Shopping Cart");
			Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");
			cartPage.clickRemoveBtn();
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
