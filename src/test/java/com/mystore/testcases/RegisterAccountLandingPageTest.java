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
import com.mystore.pageobjects.RegisterAccountPage;
import com.mystore.utility.Log;
import com.mystore.utility.RetryAnalyzer;

/**
 * Author Ayanda Khaka 
 * 
 * This method test register account landing page
 */
public class RegisterAccountLandingPageTest extends BaseTest {
	
	HomePage page;
	RegisterAccountPage rap;
	
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
	
	@Test(groups = {"Regression","Sanity"})
	public void registrationAccountTest() throws InterruptedException {
		Log.info("registrationAccountTest");
		page = new HomePage();
		rap = new RegisterAccountPage();
		Log.info("User clicks on My account link");
		page.clickMyaccountLink();
		Log.info("User clicks on Rigistration link");
		page.clickOnRegisterLink();
		Log.info("User verify registration success header");
		Assert.assertEquals(rap.getRegisterHeaderText(), prop.getProperty("registerHeader"));
		Log.endTestCase("registrationAccountTest");
	}

	
}
