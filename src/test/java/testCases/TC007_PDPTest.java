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
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;
	ProductDisplayPage pdp;
	MyAccountPage map;

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

			sp = new SearchResultsPage(driver);
			String expHeader = sp.verifyResultsHeader();

			Assert.assertEquals(expHeader, "Search - iMac");
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail(e + "Exeception is caused hence TC failed");
		}

		try {
			if (sp.verifyProductTile() == true) {
				sp.clickImacImg();
				Assert.assertTrue(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "Element Identification Failed");
		}
		pdp = new ProductDisplayPage(driver);
		Assert.assertEquals(driver.getTitle(), "iMac");

	}

	@Test(priority = 1)
	public void verifyPDPThumnails() throws AWTException, InterruptedException {

		try {
			if (pdp.verifyThumbnail() == true) {
				pdp.clickImacThumbnailImg();
				pdp.clickNextArrowButton();
				Assert.assertTrue(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "Element Identification Failed");
		}

		if (pdp.verifyImacSideView() == true) {
			pdp.clickiMacSideView();

			Assert.assertTrue(true);

			if (pdp.verifyiMacTiltView() == true) {
				pdp.clickiMacTiltVieww();
				Assert.assertTrue(true);
			}

		} else {
			Assert.fail();
		}

	}

	@Test(priority = 2)
	public void verifyProductDetails() {

		try {
			Assert.assertEquals(pdp.getProductName(), "iMac");
			Assert.assertEquals(pdp.getProductBrand(), "Apple");

			if (pdp.getProductCode().contains("Product 14")) {

				if (pdp.getProductAvailability().contains("In Stock")) {
					Assert.assertEquals(pdp.getProductPrice(), "$122.00");
					Assert.assertEquals(pdp.getDefaultQty(), "1");
					Assert.assertEquals(pdp.getProductDescription(),
							"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo processors. And more memory standard. "
									+ "Combine this with Mac OS X Leopard and iLife ´08, and it´s more all-in-one than ever. "
									+ "iMac packs amazing performance into a stunningly slim space.");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "Test Case Failed");
		}

	}

	@AfterMethod
	public void logoutTest() {
		map = new MyAccountPage(driver);
		try {
			hp.clickMyAccount();
			map.clickLogout();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "is caused");
		}

	}

}
