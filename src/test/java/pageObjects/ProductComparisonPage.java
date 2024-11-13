package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage {

	public ProductComparisonPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=product/compare']")
	WebElement productComparisonHeader;

	@FindBy(xpath = "//td[normalize-space(text())='Product 14']")
	WebElement iMacProductId;

	@FindBy(xpath = "(//table[@class='table table-bordered']//a)[1]")
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
		
			jSClick(removeBtn);

	

	}

	public String verifyproductRemovedSuccessMessage() {
		return productRemovedSuccessMessage.getText();

	}

}
