package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(id = "input-payment-firstname")
	private WebElement firstName;

	@FindBy(id = "input-payment-lastname")
	private WebElement lastName;

	@FindBy(id = "input-payment-company")
	private WebElement company;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	private WebElement address1;

	@FindBy(id = "input-payment-city")
	private WebElement city;

	@FindBy(id = "input-payment-postcode")
	private WebElement postalCode;

	@FindBy(id = "input-payment-country")
	private WebElement countryDropdown;

	@FindBy(id = "input-payment-zone")
	private WebElement stateDropdown;

	@FindBy(id = "button-payment-address")
	private WebElement billingContinueBtn;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	private WebElement checkoutBtn;

	@FindBy(xpath = "(//input[@name='payment_address'])[2]")
	private WebElement newAddressradioBtn;

	@FindBy(xpath = "//input[@name='shipping_method']")
	private WebElement shippingRate;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement commentsArea;

	@FindBy(xpath = "//textarea[@name='comment']//following::input")
	private WebElement deliveryContinueBtn;
	
	@FindBy(xpath = "//a[@href='#collapse-shipping-address']//following::input[10]")
	private WebElement shippingContinueBtn;

	@FindBy(xpath = "//input[@value='cod']")
	private WebElement codRadioBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement termsCheckbox;

	@FindBy(xpath = "//input[@type='checkbox']//following::input")
	private WebElement paymentContinueBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody/tr/td[1]")
	private WebElement orderedProductName;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody/tr/td[2]")
	private WebElement orderedProductID;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//tfoot/tr[3]/td[2]")
	private WebElement orderTotal;

	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmOrderBtn;

	public void enterFirstName() {
		typeTextIntoElement(firstName, "Ravi", 1);

	}

	public void enterLastName() {
		typeTextIntoElement(lastName, "Tester", 1);

	}

	public void enterCompany() {
		typeTextIntoElement(company, "Global Solutions", 1);

	}

	public void enterAddress1() {
		typeTextIntoElement(address1, "No: 23/23 LIC Street, Saidapet", 1);

	}

	public void enterCity() {
		typeTextIntoElement(city, "Chennai", 1);

	}

	public void enterPostalCode() {
		typeTextIntoElement(postalCode, "600019", 1);

	}

	public void selectCountryfromDropdown() {
		selectOptionInDropdown(countryDropdown, "India", 0);

	}

	public void selectStatefromDropdown() {
		selectOptionInDropdown(stateDropdown, "Tamil Nadu", 0);

	}

	public void clicknewAddressradioBtnBtn() {
		clickOnElement(newAddressradioBtn, 0);

	}

	public void clickCheckoutBtn() {
		clickOnElement(checkoutBtn, 0);

	}

	public void clicknewAddressradioBtn() {
		
			jSClick(newAddressradioBtn);

		

	}

	public void clickBillingContinueBtn() {
		
			jSClick(billingContinueBtn);

	
	}

	public String getShippingRate() {
		return shippingRate.getText();

	}

	public void enterComments() {
		typeTextIntoElement(commentsArea, "Please delivery this product to my neighboour", 3);

	}

	public void clickDeliveryContinueBtn() {
		
			jSClick(deliveryContinueBtn);

		

	}

	public boolean isCODenabled() {
		return codRadioBtn.isEnabled();

	}

	public void checkTerms() {
		
	clickOnElement(termsCheckbox, 3);

	

	}

	public void clickPaymentContinue() {
		
			clickOnElement(paymentContinueBtn, 3);

		
	}
	
	public String getOrderedProductName() {
		return orderedProductName.getText();
	}
	
	public String getOrderdProductID() {
		return orderedProductID.getText();

	}
	
	public String getOrderTotal() {
		return orderTotal.getText();
	}
	
	public void clickConfirmOrder() {
		
			jSClick(confirmOrderBtn);
			
	
	}

	
	public void clickshippingContinueBtn() {
		
			jSClick(shippingContinueBtn);

	

	}
}
