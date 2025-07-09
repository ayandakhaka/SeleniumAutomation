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
import com.mystore.pageobjects.LaptopsAndNotebooksPage;
import com.mystore.pageobjects.RegisterAccountPage;
import com.mystore.pageobjects.RegisterAccountSuccessPage;

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

		launchApp(browser);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void verifyAccountRegisterTest() throws InterruptedException {
		
		//This is creating the instance of the pages
		page = new HomePage();
		rap = new RegisterAccountPage();
		rasp = new RegisterAccountSuccessPage();
		
		page.clickMyaccountLink();
		page.clickOnRegisterLink();
		
		rap.registerUser();
		
		String actualResults = prop.getProperty("registerSuccessText");
		String expectedResults = rasp.getRegisterAccountSuccessHeaderText();
		
		Assert.assertEquals(expectedResults, actualResults);
	}
}
