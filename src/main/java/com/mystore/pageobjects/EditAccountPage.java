/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice.Factory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseTest;

/**
 * @author Ayanda Khaka
 */
public class EditAccountPage extends BaseTest {
	
	private Action action;

	public EditAccountPage() {
		
		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "Edit Account")
	@CacheLookup
	private WebElement editAccount;
	
	@FindBy(name = "telephone")
	@CacheLookup
	private WebElement telephone;
	
	@FindBy(xpath = "//input[@value='Continue']")
	@CacheLookup
	private WebElement continueBtn;
	
	@FindBy(xpath = "//*[@id=\"account-account\"]/div[1]")
	@CacheLookup
	private WebElement editAccountSuccessMsg;
	
	public void clickEditAccount() {
		action.click(getDriver(), editAccount);
	}
	
	public void editTelephoneNumber() {
		action.type(telephone, prop.getProperty("telephone"));
	}
	
	public void clickContinue() {
		action.click(getDriver(), continueBtn);
	}
	
	public String getEditSuccessHeaderText() {
		return editAccountSuccessMsg.getText();
	}
	
	
}
