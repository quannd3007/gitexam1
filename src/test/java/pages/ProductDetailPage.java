package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductDetailPage extends BasePage{

	String XPATH_CHOOSE_SIZE = "//div[@class='swatch-option text'][@option-label='%s']";
	String XPATH_CHOOSE_COLOR = "//div[@class='swatch-option color'][@option-label='%s']";
	String ID_INPUT_QTY = "qty";
	String ID_BUTTON_ADD_TO_CART = "product-addtocart-button";
	String XPATH_MESSAGE_SUCCESS = "//div[@role='alert'][./div[@data-ui-id='message-success']]";
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void chooseSize(String size) {
		actionUtility.click(By.xpath(String.format(XPATH_CHOOSE_SIZE, size)));
	}
	
	public void chooseColor(String color) {
		actionUtility.click(By.xpath(String.format(XPATH_CHOOSE_COLOR, color)));
	}
	
	public void inputQty(int qty) {
		actionUtility.sendKeys(By.id(ID_INPUT_QTY), String.valueOf(qty));
	}
	
	public void addToCart() {
		actionUtility.click(By.id(ID_BUTTON_ADD_TO_CART));
	}
	
	public boolean messageSuccessDisplay() {
		return actionUtility.checkElementDisplay(By.xpath(XPATH_MESSAGE_SUCCESS));
	}
	
}
