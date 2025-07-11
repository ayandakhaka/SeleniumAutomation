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
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class LoginTest extends BaseTest {

	HomePage page;
	LoginPage lp;

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
	
	@Test(groups = {"Smoke","Sanity"},
			dataProvider = "loginCredentials",
			dataProviderClass = DataProviders.class)
	public void verifySuccessLogin(String email, String pass) throws InterruptedException {
		Log.startTestCase("verifySuccessLogin");
		page = new HomePage();
		lp = new LoginPage();
		Log.info("User clicks on My Account");
		page.clickMyaccountLink();
		Log.info("User clicks on login liink");
		page.clickLoginLink();
		Log.startTestCase("User enters cridentials and click on sign-in");
		lp.login(email, pass);
		
		String actualResults = page.getHomePageCurrentURL();
		String expectedResults = prop.getProperty("loginURL");
		Log.info("User verifying if login is succesful");
		Assert.assertEquals(actualResults, expectedResults);
		Log.endTestCase("verifySuccessLogin");
		
	}

}
