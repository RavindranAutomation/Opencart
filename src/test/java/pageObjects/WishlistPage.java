package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage{

	public WishlistPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=account/wishlist'])[2]")
    WebElement wishlistSubmenu;
	
	@FindBy(xpath = "//button[@data-original-title='Add to Cart']")
	 WebElement wishlistAddToCartBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement wishlistToCartSuccessMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(), 'iMac')]//following::a[1]")
	WebElement wishlistShoppingcartLink;
	

	
	public boolean isWishlistSubmenuDisplayed() {
		return wishlistSubmenu.isDisplayed();

	}

	public void clickwishlistAddToCartBtn() {
		wishlistAddToCartBtn.click();

	}
	
	public boolean iswishlistToCartSuccessMessageDisplayed() {
		return wishlistToCartSuccessMessage.isDisplayed();

	}
	
	public void clickwishlistShoppingcartLink() {
		wishlistShoppingcartLink.click();
	}
}
