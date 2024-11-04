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
import testBase.BaseClass;

public class TC008_AddToCartTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;
	ProductDisplayPage pdp;
	MyAccountPage map;
	CartPage cp;

	@BeforeMethod
	public void loginTest() {
		try {
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

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e + "Exeception is caused hence TC failed");
		}

	}

	@Test(priority = 1)
	public void verifyAddtoCartFromSearchResultsPage() {
		sp = new SearchResultsPage(driver);
		String expHeader = sp.verifyResultsHeader();

		Assert.assertEquals(expHeader, "Search - iMac");

		cp = new CartPage(driver);

		try {
			sp.clickiMacAddToCartBtn();

			if (sp.verifyCompareSuccessMessage() == true) {
				sp.clickShoppingCartLink();

				if (cp.isShoppingCartProductImageDisplayed() == true) {
					cp.clickRemoveBtn();
					Assert.assertEquals(driver.getTitle(), "Shopping Cart");
					Assert.assertEquals(cp.getShoppingCartProductname(), "iMac");
				}

			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "test Case is Failed");
		}

	}

}
