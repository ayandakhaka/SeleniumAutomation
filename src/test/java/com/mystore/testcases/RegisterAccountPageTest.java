/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LaptopsAndNotebooksPage;
import com.mystore.pageobjects.RegisterAccountPage;
import com.mystore.pageobjects.RegisterAccountSuccessPage;
import com.mystore.utility.Log;

/**
 * Author : Ayanda Khaka
 * 
 * This class tests if user is registered successful
 */
public class RegisterAccountPageTest extends BaseTest {

	HomePage page;
	LaptopsAndNotebooksPage lanp;
	RegisterAccountPage rap;
	RegisterAccountSuccessPage rasp;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		Log.info("Launching the browser");
		launchApp(browser);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"},
			dataProvider = "registration",
			dataProviderClass = DataProviders.class)
	public void verifyAccountRegisterTest(String tellno, String pass, String confpass) throws InterruptedException {
		Log.startTestCase("verifyAccountRegisterTest");
		//This is creating the instance of the pages
		page = new HomePage();
		rap = new RegisterAccountPage();
		rasp = new RegisterAccountSuccessPage();
		Log.info("User clicks on My account link");
		page.clickMyaccountLink();
		Log.info("User clicks on register link");
		page.clickOnRegisterLink();
		Log.info("User enter details to register");
		rap.registerUser(tellno, pass, confpass);
		
		String actualResults = prop.getProperty("registerSuccessText");
		
		String expectedResults = rasp.getRegisterAccountSuccessHeaderText();
		Log.info("User verify that the user is registered successfully");
		Assert.assertEquals(expectedResults, actualResults);
		Log.endTestCase("verifyAccountRegisterTest");
	}
}
