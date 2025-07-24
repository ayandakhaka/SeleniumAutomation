/**
 * 
 */
package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.EditAccountPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class EditAccountTest extends BaseTest {
	
	HomePage page;
	LoginPage lp;
	EditAccountPage eap;
	
	@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		Log.info("Launching the browser");
		launchApp(browser);

	}

	@AfterClass(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, priority = 1)
	public void verifyEditAccountSuccessMessageText()
		throws InterruptedException {
		Log.startTestCase("verifyEditAccountSuccessMessageText");
		page = new HomePage();
		lp = new LoginPage();
		eap = new EditAccountPage();
		
		page.clickMyaccountLink();
		Log.info("User clicks on login Link");
		page.clickLoginLink();
		Log.info("User enters credentials and click sign in");
		lp.login(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("User clicks on Edit Account");
		eap.clickEditAccount();
		Log.info("User edit telephone number field");
		eap.editTelephoneNumber();
		Log.info("User clicks on continue button");
		eap.clickContinue();
		
		String actualResults = prop.getProperty("editSuccessMessageText");
		String expectedResults = eap.getEditSuccessHeaderText();
		
		Log.info("User verify edit account success message");
		Assert.assertEquals(actualResults, expectedResults, "Failed to verify edit account message");
		Log.endTestCase("verifyEditAccountSuccessMessageText");
	}
	
	@Test(groups = {"Regression","Sanity"}, priority = 2)
	public void verifyAccountPageCurrentURL() {
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/account");
	}

}
