package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{


	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;

	@FindBy(linkText = "Login")   // Login link added in step5
	WebElement linkLogin;
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBar;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchButton;
	


	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}

	public void clickRegister()
	{
		lnkRegister.click();
	}

	public void clickLogin()
	{
		linkLogin.click();
	}
	
	public void enterProductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.click();
		searchBar.sendKeys("iMac");
		
	}
	
	public void clickSearchButton() {
		searchButton.click();

	}
	
	public void clearSearchBar() {
		searchBar.clear();

	}
	
	public void enterInvalidProductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.click();
		searchBar.sendKeys("Lexus Car");
	
	
	}
}
