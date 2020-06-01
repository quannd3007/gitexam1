package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class OrderSuccessPage extends BasePage{

	String XPATH_ORDER_NUMBER = "//a[@class='order-number']";
	
	public OrderSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean checkOrderNumberDisplay() {
		return actionUtility.checkElementDisplay(By.xpath(XPATH_ORDER_NUMBER));
	}

}
