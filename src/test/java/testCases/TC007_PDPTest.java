package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC007_PDPTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;
	ProductDisplayPage pdp;

	@Test
	public void verifyPDPThumnails() throws AWTException, InterruptedException {
		// HomePage
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

		} catch (AWTException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
