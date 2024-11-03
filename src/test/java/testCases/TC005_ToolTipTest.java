package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC005_ToolTipTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	SearchResultsPage sp;

	@Test
	public void verifyAddToCartToolTipTextOfTheProduct() {
		logger.info("***** Starting TC005_ToolTipTest *****");
		try {
			hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			hp.clickHomeBtn();

			Assert.assertEquals(hp.getAddtoWishListToolTip(), "Add to Wish List");
			Assert.assertEquals(hp.getCompareProductToolTip(), "Compare this Product");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
