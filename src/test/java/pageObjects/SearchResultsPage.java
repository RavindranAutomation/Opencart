package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	


}
