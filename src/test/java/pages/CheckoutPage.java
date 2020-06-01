package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage{

	String XPATH_BUTTON_NEW_ADDRESS = "//div[@class='new-address-popup']/button";
	String XPATH_BUTTON_SHIP_HERE = "//button[@class='action primary action-save-address']";
	
	String NAME_INPUT_FIRST_NAME = "firstname";
	String NAME_INPUT_LAST_NAME = "lastname";
	String NAME_INPUT_STREET = "street[0]";
	String NAME_INPUT_CITY = "city";
	String NAME_INPUT_STATE = "region_id";
	String NAME_INPUT_ZIPCODE = "postcode";
	String NAME_INPUT_COUNTRY = "country_id";
	String NAME_INPUT_PHONE_NUMBER = "telephone";
	
	String XPATH_SHIPPING_METHOD = "//tr[.//td[text()='%s']]//input";
	String XPATH_BUTTON_NEXT = "//button[@data-role='opc-continue']";
	String XPATH_BUTTON_PLACE_ORDER = "//button[@class='action primary checkout']";
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get("https://demo.smartosc.com/checkout");
	}
	
	public boolean checkShippingAddressFormDisplay() {
		return actionUtility.checkElementDisplay(By.xpath(NAME_INPUT_FIRST_NAME), 10);
	}
	
	public boolean checkButtonNewAddressDisplay() {
		return actionUtility.checkElementDisplay(By.xpath(XPATH_BUTTON_NEW_ADDRESS), 10);
	}
	
	public void clickOnNewAddressButton() {
		actionUtility.click(By.xpath(XPATH_BUTTON_NEW_ADDRESS));
	}
	
	public void clickOnShipHereButton() {
		actionUtility.click(By.xpath(XPATH_BUTTON_SHIP_HERE));
	}
	
	public void fillShippingAddressInfo(String firstName, String lastName, 
			String streetAddress, String city, String state, 
			String zipCode, String country, String phoneNumber) {
		
		actionUtility.sendKeys(By.name(NAME_INPUT_FIRST_NAME), firstName);
		actionUtility.sendKeys(By.name(NAME_INPUT_LAST_NAME), lastName);
		actionUtility.sendKeys(By.name(NAME_INPUT_STREET), streetAddress);
		actionUtility.sendKeys(By.name(NAME_INPUT_CITY), city);
		actionUtility.selectItem(By.name(NAME_INPUT_STATE), state);
		actionUtility.sendKeys(By.name(NAME_INPUT_ZIPCODE), zipCode);
		actionUtility.selectItem(By.name(NAME_INPUT_COUNTRY), country);
		actionUtility.sendKeys(By.name(NAME_INPUT_PHONE_NUMBER), phoneNumber);
		
	}
	
	public void chooseShippingMethod(String method) {
		actionUtility.click(By.xpath(String.format(XPATH_SHIPPING_METHOD, method)));
	}
	
	public void clickOnNextButton() {
		actionUtility.click(By.xpath(XPATH_BUTTON_NEXT));
	}
	
	public void clickOnPlaceOrderButton() {
		// wait untile loading invisible
		waitLoadingInvisibility();
		actionUtility.click(By.xpath(XPATH_BUTTON_PLACE_ORDER));
	}

	
}
