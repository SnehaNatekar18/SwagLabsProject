package swagLabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.abstractComponents.AbstractComponent;

public class ConfirmationPage  extends AbstractComponent  {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css = ".complete-header")
	WebElement completeHeader;
	
	public String getConfirmMessage() {
		return completeHeader.getText();

	}


}
