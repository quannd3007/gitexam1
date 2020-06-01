package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

	String ID_INPUT_EMAIL = "email";
	String ID_INPUT_PASSWORD = "pass";
	String ID_BUTTON_SIGN_IN = "send2";
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String email, String pass) {
		actionUtility.sendKeys(By.id(ID_INPUT_EMAIL), email);
		actionUtility.sendKeys(By.id(ID_INPUT_PASSWORD), pass);
		actionUtility.click(By.id(ID_BUTTON_SIGN_IN));
	}
}
