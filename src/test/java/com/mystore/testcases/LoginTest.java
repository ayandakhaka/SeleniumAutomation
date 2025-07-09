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

		launchApp(browser);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifySuccessLogin() throws InterruptedException {
		Log.startTestCase("Login Test");
		page = new HomePage();
		lp = new LoginPage();
		Log.info("User clicks on My Account");
		page.clickMyaccountLink();
		Log.info("User clicks on login liink");
		page.clickLoginLink();
		Log.startTestCase("User enters cridentials and click on sign-in");
		lp.login(prop.getProperty("email"), prop.getProperty("password"));
		
		String actualResults = page.getHomePageCurrentURL();
		String expectedResults = prop.getProperty("loginURL");
		Log.info("User verifying if login is succesful");
		Assert.assertEquals(actualResults, expectedResults);
		
	}

}
