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
import com.mystore.pageobjects.AccountPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.RegisterAccountPage;

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

		launchApp(browser);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void registrationAccountTest() throws InterruptedException {
		page = new HomePage();
		rap = new RegisterAccountPage();
		page.clickMyaccountLink();
		page.clickOnRegisterLink();
		Assert.assertEquals(rap.getRegisterHeaderText(), prop.getProperty("registerHeader"));
	}

	
}
