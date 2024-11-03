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
	
}
