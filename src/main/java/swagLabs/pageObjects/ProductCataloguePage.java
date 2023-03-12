package swagLabs.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.abstractComponents.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = ".inventory_item")
	List<WebElement> products;

	By productsBy = By.cssSelector(".inventory_item");
	By itemName = By.className("inventory_item_name");
	By addToCart = By.cssSelector(".pricebar button");
	By removeButton = By.cssSelector("#remove-sauce-labs-bike-light");
	
	public List<WebElement> getProdctList( ) {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream().filter(product -> product.findElement(itemName)
				.getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(removeButton);
		prod.findElement(removeButton).click();
		waitForElementToAppear(addToCart);
		prod.findElement(addToCart).click();

	}
	

}
