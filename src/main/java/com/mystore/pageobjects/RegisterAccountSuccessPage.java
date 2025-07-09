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
public class RegisterAccountSuccessPage extends BaseTest {
	
	Action action;
	
	public RegisterAccountSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	private WebElement registerAccountSuccessHeaderText;
	
	@FindBy(xpath = "//a[contains(@class,'btn') and text()='Continue']")
	private WebElement continueBtn;
	
	public AccountPage clickContinueButton() {
		//action.explicitWait(driver, continueBtn, 10);
		action.click(getDriver(), continueBtn);
		return new AccountPage();
	}
	
	public String getRegisterAccountSuccessHeaderText() {
		
		return registerAccountSuccessHeaderText.getText();
	}

	
}
