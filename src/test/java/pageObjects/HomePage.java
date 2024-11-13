package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(linkText = "Login") // Login link added in step0
	WebElement linkLogin;

	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=common/home']")
	WebElement homeButton;

	@FindBy(xpath = "((//div[@class='button-group']//button)[2]")
	WebElement wishListTT;

	@FindBy(xpath = "((//div[@class='button-group']//button)[3]")
	WebElement compareTT;

	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart']/following-sibling::span)[1]")
	WebElement shoppingcartHeaderLink;

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=information/sitemap']")
	WebElement sitemapFooterLink;

	public void clickMyAccount() {

		jSClick(lnkMyaccount);

	}

	public void clickRegister() {

		jSClick(lnkRegister);

	}

	public void clickLogin() {

		jSClick(linkLogin);

	}

	public void enterProductName() {
		waitForElement(searchButton, 0);
		searchBar.sendKeys("iMac");

	}

	public void clickSearchButton() {

		jSClick(searchButton);

	}

	public void clearSearchBar() {
		searchBar.clear();

	}

	public void enterInvalidProductName() {
		waitForVisibilityOfElement(searchBar, 0);
		searchBar.sendKeys("Lexus Car");

	}

	public void clickHomeBtn() {

		waitForElement(homeButton, 0).click();
		;

	}

	public String getAddtoWishListToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(wishListTT);
		return wishListTT.getAttribute("data-original-title");

	}

	public String getCompareProductToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(compareTT);
		return compareTT.getAttribute("data-original-title");

	}

	public void clickshoppingcartHeaderLink() {

		jSClick(shoppingcartHeaderLink);

	}

	public void clicksitemapFooterLink() {

		jSClick(sitemapFooterLink);

	}

}
