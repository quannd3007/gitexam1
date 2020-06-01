package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderSuccessPage;
import pages.ProductDetailPage;

public class PlaceOrderSuccessfullyTest {

	static WebDriver driver;

	static HomePage homePage;
	static LoginPage loginPage;
	static ProductDetailPage productDetailPage;
	static CheckoutPage checkoutPage;
	static OrderSuccessPage orderSuccessPage;

	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--no-sandbox");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
	}

	public static void preCondition() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		productDetailPage = new ProductDetailPage(driver);
		checkoutPage = new CheckoutPage(driver);
		orderSuccessPage = new OrderSuccessPage(driver);
	}

	public static void main(String[] args) throws Exception {
		// initialize WebDriver
		initDriver();

		// initialize precondition
		preCondition();

		// go to login page
		homePage.open().clickOnSignIn();

		// login
		loginPage.login("hihihahahehe@gmail.com", "Test123456");
		
		// check user log in successfully
		if (homePage.checkUserLoggedIn()) {
			System.out.println("User log in successfully!");
		} else {
			throw new Exception("Error when logging in!");
		}

		// add product to cart
		productDetailPage.open("https://demo.smartosc.com/hero-hoodie.html");
		productDetailPage.chooseSize("L");
		productDetailPage.chooseColor("Black");
		productDetailPage.addToCart();
		// check product is added to cart successfully
		if (productDetailPage.messageSuccessDisplay()) {
			System.out.println("Add product to cart successfully!");
		} else {
			throw new Exception("Error when adding product to cart!");
		}

		// checkout
		checkoutPage.open();

		// check first time place order
		if (checkoutPage.checkShippingAddressFormDisplay()) {
			checkoutPage.fillShippingAddressInfo("quand", "nd", "street", "city", "Alaska", "12345", "Vietnam",
					"123456789");
			// check if button new address display
		} else if (checkoutPage.checkButtonNewAddressDisplay()) {
			checkoutPage.clickOnNewAddressButton();
			checkoutPage.fillShippingAddressInfo("quand", "nd", "street", "city", "Alaska", "12345", "Vietnam",
					"123456789");
			checkoutPage.clickOnShipHereButton();
		}

		checkoutPage.chooseShippingMethod("Fixed");
		checkoutPage.clickOnNextButton();
		checkoutPage.clickOnPlaceOrderButton();

		// check place order successfully when new order number displays
		if (orderSuccessPage.checkOrderNumberDisplay()) {
			System.out.println("Place order successfully!");
		} else {
			throw new Exception("Error!! Please check!!");
		}

		
		// quit driver
		driver.quit();
	}
}
