package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseTest;

public class ProductAddedToCartPage extends BaseTest {
	
	Action action;
	
	public ProductAddedToCartPage() {
		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	private WebElement addToCartSuccessHeaderMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]//button[@class='close']")
	private WebElement closeXButton;
	
	public String getAddToCartSuccessHeaderMessage() {
		// Execute JavaScript to remove the button from the DOM
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].remove();", closeXButton);
		return addToCartSuccessHeaderMessage.getText();
	}

}
