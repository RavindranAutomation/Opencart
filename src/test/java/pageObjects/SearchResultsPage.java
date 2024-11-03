package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement searchResultsHeader;

	@FindBy(xpath = "//img[@src='http://localhost/opencartsite/upload/image/cache/catalog/demo/imac_1-228x228.jpg']")
	WebElement iMacImage;

	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=product/product&product_id=41&search=iMac'])[2]")
	WebElement iMacName;
	
	@FindBy(xpath = "(//div[@id='content']//p)[2]")
	WebElement searchResluts;
	
	@FindBy(xpath = "//a[@href='http://localhost/opencartsite/upload/index.php?route=product/product&product_id=41&search=iMac']//following::div[3]/button[2]")
	WebElement iMacWishListBtn;
	
	@FindBy(xpath = "//a[@href='http://localhost/opencartsite/upload/index.php?route=product/product&product_id=41&search=iMac']//following::div[3]/button[3]")
	WebElement iMacCompareBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement compareSuccessMessage;
	
	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=product/compare'])[1]")
	WebElement productComparisonLink;
	
	@FindBy(xpath = "//div[@class='product-thumb']")
	WebElement productTile;
	
	@FindBy(xpath = "//img[@src='http://localhost/opencartsite/upload/image/cache/catalog/demo/imac_1-228x228.jpg']")
	WebElement iMacImgLink;
	
	public String verifyResultsHeader() {
		return searchResultsHeader.getText();

	}
	
	public boolean isiMacDisplayed() {
		return iMacImage.isDisplayed();

	}
	
	public boolean isiMacNameDisplayed() {
		return iMacName.isDisplayed();

	}
	
	public boolean isNoSearchResultsDisplayed() {
		return searchResluts.isDisplayed();

	}
	
	public String getImacAddtoWishListToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(iMacWishListBtn);
		return iMacWishListBtn.getAttribute("data-original-title");

	}
	
	public String getImacCompareProductToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(iMacCompareBtn);
		return iMacCompareBtn.getAttribute("data-original-title");

	}
	
	public void clickImacCompareBtn() {
		
		iMacCompareBtn.click();
	}
	
	public boolean verifyCompareSuccessMessage() {
		return compareSuccessMessage.isDisplayed();

	}
	
	
	public void clickProductComparisonLink() {
		productComparisonLink.click();

	}
	
	public boolean verifyProductTile() {
		return productTile.isDisplayed();

	}

	public void clickImacImg() {
		iMacImgLink.click();

	}

}
