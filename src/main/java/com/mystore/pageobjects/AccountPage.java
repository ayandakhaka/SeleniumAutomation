/**
 * 
 */
package com.mystore.pageobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseTest;

/**
 * 
 */
public class AccountPage extends BaseTest {
	
	Action action;
	
	public AccountPage() {
		
		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	public WebElement laptopsAndNoteBook;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
	public WebElement ShowAllLaptopsAndNotebooks;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	private WebElement successHeaderText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
	private WebElement continueButton;
	
	@FindBy(id = "cart-total")
	private WebElement addToCartButtonPrice;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button/i")
	private WebElement removePrice;
	
//	public void clickAddToCartButtonPrice() {
//		if(!addToCartButtonPrice.getText().contains(" 0 item(s) - $0.00")) {
//			action.click(getDriver(), addToCartButtonPrice);
//			action.explicitWait(getDriver(), removePrice, 10);
//		}
//	}
	
	public void clickAddToCartButtonPrice() {
	    String cartText = addToCartButtonPrice.getText();

	    // Extract price using regex
	    Pattern pattern = Pattern.compile("\\$([0-9]+\\.?[0-9]*)");
	    Matcher matcher = pattern.matcher(cartText);

	    if (matcher.find()) {
	        double price = Double.parseDouble(matcher.group(1));

	        if (price > 0.00) {
	            action.click(getDriver(), addToCartButtonPrice);
	            action.click(getDriver(), removePrice);
	           // action.explicitWait(getDriver(), addToCartButtonPrice, 10);
	        }
	        System.out.println("Price = " + price);
	    }
	}
	
	public LaptopsAndNotebooksPage navigateLaptopsAndNoteBookPage() {
		action.mouseover(getDriver(), laptopsAndNoteBook);
		action.click(getDriver(), ShowAllLaptopsAndNotebooks);
		return new LaptopsAndNotebooksPage();
		
	}
	
	public String getRegistrationHeaderText() {
		String text = successHeaderText.getText();
		return text;
	}
	

}
