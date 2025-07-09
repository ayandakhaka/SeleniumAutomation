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
