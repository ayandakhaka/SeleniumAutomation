/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseTest;

/**
 * 
 */
public class AddToCartPage extends BaseTest {

	Action action;
	
	public AddToCartPage() {
		
		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(name = "option[225]")
	public WebElement deliveryDateEl;
	
	@FindBy(name = "quantity")
	public WebElement quantityEl;
	
	@FindBy(id = "button-cart")
	public WebElement addToCartbtn;
	
	@FindBy(xpath = "//*[@id=\"product-product\"]/div[1]")
	public WebElement addSuccessMessage;
	
	@FindBy(xpath = "//button[.//span[@id='cart-total']]")
	public WebElement total;
	
	public Double getTotal() {
		
		action.explicitWait(getDriver(), total, 5000);
		String totalFromCart = total.getText();
		String total = totalFromCart.split("\\$")[1];
		Double finalTotal = Double.parseDouble(total);
		return finalTotal;	
	}
	
	public void clickAddToCartButton() {
		action.click(getDriver(), addToCartbtn);
	}
	
	public void enterAvailableOptions(String deliveryDate, String quantity) {
		
		action.type(deliveryDateEl, deliveryDate);
		action.type(quantityEl, quantity);
		clickAddToCartButton();
	}
	
	
}
