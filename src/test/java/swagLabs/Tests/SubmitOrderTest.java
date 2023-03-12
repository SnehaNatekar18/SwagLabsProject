package swagLabs.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import swagLabs.TestComponents.BaseTest;
import swagLabs.pageObjects.CartPage;
import swagLabs.pageObjects.CheckoutPage;
import swagLabs.pageObjects.ConfirmationPage;
import swagLabs.pageObjects.LandingPage;
import swagLabs.pageObjects.ProductCataloguePage;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String,String> input) throws IOException {
		ProductCataloguePage productCataloguePage = landingPage.loginApplication(input.get("username"), input.get("password"));

		List<WebElement> products = productCataloguePage.getProdctList();
		productCataloguePage.addProductToCart(input.get("productName"));
		CartPage cartPage = productCataloguePage.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));

	}

	@DataProvider

	public Object[][] getData() throws IOException {
		
		 List<HashMap<String, String>> data = getJsonDataToMap();
		 return new Object[][] { { data.get(0) } };

		
	}

}
