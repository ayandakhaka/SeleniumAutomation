/**
 * 
 */
package com.mystore.pageobjects;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseTest;

/**
 * 
 */
public class RegisterAccountPage extends BaseTest
{
	Action action;

	public RegisterAccountPage() {

		action = new Action();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "telephone")
	private WebElement telephone;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "confirm")
	private WebElement confirmPass;

	@FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	private WebElement yesSubscribeOption;

	@FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
	private WebElement noSubscribeOption;

	@FindBy(name = "agree")
	private WebElement privatePolicyCheckbox;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement continueBtn;

	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	private WebElement registerHeaderText;

	public String getRegisterHeaderText() {
		System.out.println("Rgistration header = " + registerHeaderText.getText());
		return registerHeaderText.getText();
	}

	public void clickYesRadioButton() {
		action.click(getDriver(), yesSubscribeOption);
	}

	public void clickNoRadioButton() {
		action.click(getDriver(), noSubscribeOption);
	}

	public void checkPrivatePolicyCheckbox() {
		action.click(getDriver(), privatePolicyCheckbox);
	}

	public void clickContinueBtn() {
		action.click(getDriver(), continueBtn);
	}


	public AccountPage registerUser(
			String phoneN,
			String pass,
			String passConfirm) 
	{

		String emailGenerator = randomString().toLowerCase() + "@gmail.com";

		action.type(firstName, generateString());
		action.type(lastName, generateString());
		action.type(email, emailGenerator);
		BigDecimal bd = new BigDecimal(phoneN);
		action.type(telephone, bd.toPlainString());
		action.type(password, pass.replace(".0", ""));
		action.type(confirmPass, passConfirm.replace(".0", ""));
		clickYesRadioButton();
		checkPrivatePolicyCheckbox();
		clickContinueBtn();
		return new AccountPage();
	}
}
