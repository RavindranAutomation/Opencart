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
import testBase.BaseClass;

public class TC008_AddToCartTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchPage;
	ProductDisplayPage pdpPage;
	MyAccountPage myAccPage;
	CartPage cartPage;
	

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

	@Test(priority = 1,groups = {"Sanity","Regression","Master"})
	public void verifyAddtoCartFromSearchResultsPage() {


		try {
			searchPage.clickiMacAddToCartBtn();	
			searchPage.clickShoppingCartLink();	
			cartPage = new CartPage(driver);
				cartPage.clickRemoveBtn();
				Assert.assertEquals(driver.getTitle(), "Shopping Cart");
				Assert.assertEquals(cartPage.getShoppingCartProductname(), "iMac");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e + "test Case is Failed");
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
