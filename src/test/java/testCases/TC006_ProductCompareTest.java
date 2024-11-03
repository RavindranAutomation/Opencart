package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC006_ProductCompareTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;
	ProductComparisonPage pcp;

	@Test
	public void verifyProductCompareWith() {
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

			Assert.assertEquals(sp.getImacAddtoWishListToolTip(), "Add to Wish List");
			Assert.assertEquals(sp.getImacCompareProductToolTip(), "Compare this Product");

			sp.clickImacCompareBtn();

			Assert.assertEquals(sp.verifyCompareSuccessMessage(), true);
			sp.clickProductComparisonLink();
			pcp = new ProductComparisonPage(driver);

			Assert.assertEquals(driver.getTitle(), "Product Comparison");

			Assert.assertEquals(pcp.verifyProductComParisonHeader(), true);

			Assert.assertEquals(pcp.verifyImacProductId(), "Product 14");

			Assert.assertEquals(pcp.verifyImacProductName(), "iMac");

			pcp.clickRemoveBtn();

			if (pcp.verifyproductRemovedSuccessMessage()
					.contains("Success: You have modified your product comparison!")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}

}
