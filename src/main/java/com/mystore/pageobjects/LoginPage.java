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
public class LoginPage extends BaseTest {

	Action action;
	
	public LoginPage() {

		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "email")
	public WebElement emailElement;

	@FindBy(name = "password")
	public WebElement passordElement;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	public WebElement loginButton;

	public AccountPage login(String email, String password) {
		
		action.type(emailElement, email);
		action.type(passordElement, password);
		action.click(getDriver(), loginButton);
		return new AccountPage();
	}
}
