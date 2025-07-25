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
public class HomePage extends BaseTest {

	Action action;
	
	public HomePage() {
		
		action= new Action();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]")
	private WebElement myAccountLink;

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
	private WebElement header;
	
	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement laptopsAndNotebooks;
	
	@FindBy(linkText = "Show AllLaptops & Notebooks")
	private WebElement allLaptopsAndNotepadsLink;
	
	public LaptopsAndNotebooksPage clickOnAllLaptopsAndNotepadsLink() {
		action.click(getDriver(), allLaptopsAndNotepadsLink);
		return new LaptopsAndNotebooksPage();
	}
	
	public void hoverOnLaptopsAndNotebooks() {
		action.mouseOverElement(getDriver(), laptopsAndNotebooks);
	}

	public String getHeaderText() {

		return header.getText();
	}

	public RegisterAccountPage clickOnRegisterLink() {

		action.click(getDriver(), registerLink);
		return new RegisterAccountPage();
	}

	public void clickMyaccountLink() throws InterruptedException {
		action.explicitWait(getDriver(), myAccountLink, 20);
		action.click(getDriver(), myAccountLink);
	}

	public void clickLoginLink() {
		action.click(getDriver(), loginLink);
	}
	
	public String getTitle() {
		return action.getTitle(getDriver());
	}
	
	public String getHomePageCurrentURL() {
		return action.getCurrentURL(getDriver());
	}


}
