package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage{

	public ProductComparisonPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath ="//a[@href='http://localhost/opencartsite/upload/index.php?route=product/compare']")
	WebElement productComparisonHeader;

	@FindBy (xpath = "//table[contains(@class,'table table-bordered')]/tbody[1]/tr[4]/td[2]")
	WebElement iMacProductId;


	@FindBy(xpath="(//table[@class='table table-bordered']//a)[1]")
	WebElement iMacProductName;

	@FindBy(xpath = "(//table[@class='table table-bordered']//a)[2]")
	WebElement removeBtn;

	@FindBy(xpath = "(//div[@id='product-compare']//div)[1]")
	WebElement productRemovedSuccessMessage;


	public boolean verifyProductComParisonHeader() {
		return productComparisonHeader.isDisplayed();

	}

	public String verifyImacProductId() {
		return iMacProductId.getText();

	}

	public String verifyImacProductName() {
		return iMacProductName.getText();

	}

	public void clickRemoveBtn() {
		removeBtn.click();

	}

	public String verifyproductRemovedSuccessMessage() {
		return productRemovedSuccessMessage.getText();

	}











}
