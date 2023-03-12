package swagLabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userName;	
	@FindBy(id = "password")
	WebElement passwordElement;	
	@FindBy(id = "login-button")
	WebElement login;
	@FindBy(css = ".error-message-container")
	WebElement errorMessage;
	
	public ProductCataloguePage loginApplication(String email, String password) {
		userName.sendKeys(email);
		passwordElement.sendKeys(password);
		login.click();
		ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
		return productCataloguePage;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");

	}
	
}
