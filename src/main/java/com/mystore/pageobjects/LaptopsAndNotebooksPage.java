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
public class LaptopsAndNotebooksPage extends BaseTest {

	Action action;
	
	public LaptopsAndNotebooksPage() {

		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a/img")
	private WebElement itemToAddToCart;

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[1]/i")
	public WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[2]/i")
	public WebElement addToWishList;

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[3]/i")
	public WebElement compareThisProduct;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
	private WebElement clickOnAllLaptopsAndNotebooksLink;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h2")
	private WebElement AllLaptopsAndNotebooksHeaderText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a/img")
	private WebElement addToCartItem;
	
	public void clickOnItemToAddToCart() {
		action.scrollByVisibilityOfElement(getDriver(), itemToAddToCart);
		action.click(getDriver(), itemToAddToCart);
	}
	
	public AddToCartPage clickAddToCartItem() {
		 action.click(getDriver(), addToCartItem);
		 return new AddToCartPage();
	}
	
	public String getAllLaptopsAndNotebooksHeaderText() {
		return AllLaptopsAndNotebooksHeaderText.getText();
	}
	
	public AddToCartPage clickAddToCart() {
		action.scrollByVisibilityOfElement(getDriver(), addToCart);
		action.click(getDriver(), addToCart);
		return new AddToCartPage();
	}

	public void clickAddToWishList() {

		action.click(getDriver(), addToWishList);
	}

	public boolean verifySuccessAddToWishListMessage() {

		return action.isDisplayed(getDriver(), addToWishList);
	}

	public void clickCompareThisProduct() {

		action.click(getDriver(), compareThisProduct);
	}
	
	public boolean verifySuccessCompareThisProductMessage() {

		return action.isDisplayed(getDriver(), compareThisProduct);
	}

}
