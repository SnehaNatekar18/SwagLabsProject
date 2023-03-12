package swagLabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	WebElement firstName;
	@FindBy(id = "last-name")
	WebElement lastName;
	@FindBy(id = "postal-code")
	WebElement postalCode;
	@FindBy(id = "continue")
	WebElement toContinue;
	@FindBy(id = "finish")
	WebElement finish;

	public ConfirmationPage submitOrder() {
		firstName.sendKeys("Sneha");
		lastName.sendKeys("Natekar");
		postalCode.sendKeys("400030");
		toContinue.click();
		finish.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
