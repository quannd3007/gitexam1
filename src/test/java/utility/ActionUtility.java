package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionUtility {

	WebDriver driver;
	WaitUtility waitUtility;
	
	public ActionUtility(WebDriver driver) {
		this.driver = driver;
		waitUtility = new WaitUtility(driver);
	}
	
	public void sendKeys(By locator, String data) {
		waitUtility.waitUntilVisibility(locator);
		driver.findElement(locator).sendKeys(data); 
	}
	
	public void click(By locator){
		waitUtility.waitUntilVisibility(locator);
		waitUtility.waitUntilClickable(locator);
		driver.findElement(locator).click();
	}
	
	public void selectItem(By locator, String text) {
		waitUtility.waitUntilVisibility(locator);
		waitUtility.waitUntilClickable(locator);
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
	}
	
	public boolean checkElementDisplay(By locator) {
		try {
			waitUtility.waitUntilVisibility(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean checkElementDisplay(By locator, int waitingTime) {
		try {
			waitUtility.waitUntilVisibility(locator, waitingTime);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
