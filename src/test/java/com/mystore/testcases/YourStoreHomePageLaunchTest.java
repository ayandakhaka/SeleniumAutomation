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
import com.mystore.utility.Log;

/**
 * 
 */
public class YourStoreHomePageLaunchTest extends BaseTest {
	
	HomePage homePage;
	
	
	public YourStoreHomePageLaunchTest() {
		
		homePage = new HomePage();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		launchApp(browser);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyHomePageTitle() {
		Log.startTestCase("YourStoreHomePageLaunchTest");
		String actualResults = homePage.getTitle();
		String expectedResults = prop.getProperty("homePageTitle");
		
		Assert.assertEquals(actualResults, expectedResults);
	}
	
	@Test(groups = "Smoke")
	public void verifyHomePageCurrentURL() {
		
		String actualResults = homePage.getHomePageCurrentURL();
		String expectedResults = prop.getProperty("url");
		Assert.assertEquals(actualResults, expectedResults);
	}
	
}
