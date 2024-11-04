package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage {

	public ProductDisplayPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//img[@src='http://localhost/opencartsite/upload/image/cache/catalog/demo/imac_1-228x228.jpg']")
	WebElement imacThumbnailImg;

	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	WebElement nextArrowBtn;

	@FindBy(xpath = "//img[@src='http://localhost/opencartsite/upload/image/cache/catalog/demo/imac_3-74x74.jpg']")
	WebElement iMacSideView;

	@FindBy(xpath = "//img[@src='http://localhost/opencartsite/upload/image/cache/catalog/demo/imac_2-74x74.jpg']")
	WebElement iMacTiltView;

	@FindBy(xpath = "//div[@class='btn-group']//following::h1")
	WebElement productName;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li/a")
	WebElement getBrandName;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li[2]")
	WebElement productCode;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li[3]")
	WebElement productAvailability;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[2]/li/h2")
	WebElement productPrice;

	@FindBy(xpath = "//label[@for='input-quantity']//following::input[1]")
	WebElement defaultQtyInputBox;

	@FindBy(xpath = "//div[@id='tab-description']")
	WebElement iMacProductDescription;

	public boolean verifyThumbnail() {
		return imacThumbnailImg.isDisplayed();

	}

	public void clickImacThumbnailImg() {
		imacThumbnailImg.click();

	}

	public void clickNextArrowButton() throws AWTException {
		for (int i = 0; i <= 1; i++) {
			nextArrowBtn.click();
		}

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public boolean verifyImacSideView() {
		return iMacSideView.isDisplayed();

	}

	public void clickiMacSideView() throws AWTException, InterruptedException {
		iMacSideView.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public boolean verifyiMacTiltView() {
		return iMacTiltView.isDisplayed();

	}

	public void clickiMacTiltVieww() throws AWTException, InterruptedException {
		iMacTiltView.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public String getProductName() {
		return productName.getText();

	}

	public String getProductBrand() {
		return getBrandName.getText();

	}

	public String getProductCode() {
		return productCode.getText();

	}

	public String getProductAvailability() {
		return productAvailability.getText();

	}

	public String getProductPrice() {
		return productPrice.getText();

	}

	public String getDefaultQty() {
		return defaultQtyInputBox.getAttribute("value");

	}

	public String getProductDescription() {
		return iMacProductDescription.getText();
	}

}
