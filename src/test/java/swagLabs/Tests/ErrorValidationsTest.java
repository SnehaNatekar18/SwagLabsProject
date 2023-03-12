package swagLabs.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import swagLabs.TestComponents.BaseTest;
import swagLabs.pageObjects.CartPage;
import swagLabs.pageObjects.CheckoutPage;
import swagLabs.pageObjects.ConfirmationPage;
import swagLabs.pageObjects.ProductCataloguePage;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void loginErrorValidation() throws IOException {
		String productName = "Sauce Labs Bike Light";
		landingPage.loginApplication("stand8ard_user", "se8cret_sauce");
		AssertJUnit.assertEquals("Epic sadface: Username and password do not match any user in this service",
				landingPage.getErrorMessage());

	}
	
	@Test
	
	public void productErrorValidation() throws IOException {
		String productName = "Sauce Labs Bike Light";
		ProductCataloguePage productCataloguePage = landingPage.loginApplication("standard_user", "secret_sauce");

		List<WebElement> products = productCataloguePage.getProdctList();
		productCataloguePage.addProductToCart(productName);
		CartPage cartPage = productCataloguePage.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("Sauce Labs Bike Dark");
		Assert.assertFalse(match);

	}

	

}
