package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SitemapPage extends BasePage {

	public SitemapPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//a[@href='http://localhost/opencart/upload/index.php?route=account/order'])[3]")
	WebElement shoppingcartLink;

	public void clickshoppingcartLink() {

		jSClick(shoppingcartLink);

	}

}
