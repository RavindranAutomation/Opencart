package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=checkout/cart'])[3]")
	WebElement shoppingSubHeaderMenu;

	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=product/product&product_id=41'])[4]")
	WebElement shoppingCartProductname;

	@FindBy(xpath = "(//a[@href='http://localhost/opencartsite/upload/index.php?route=product/product&product_id=41'])[3]")
	WebElement shoppingCartProductImage;
	
	@FindBy(xpath = "(//span[@class='input-group-btn']/button)[3]")
	WebElement removeBtn;

	public boolean isShoppingSubHeaderMenuDisplayed() {
		return shoppingSubHeaderMenu.isDisplayed();

	}

	public boolean isShoppingCartProductImageDisplayed() {
		return shoppingCartProductImage.isDisplayed();

	}

	public String getShoppingCartProductname() {
		return shoppingCartProductname.getText();
	}
	
	public void clickRemoveBtn() {
		try {
			removeBtn.isDisplayed();
			removeBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		

	}

}
