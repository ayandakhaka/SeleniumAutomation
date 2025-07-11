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
import com.mystore.utility.Log;

/**
 * 
 */
public class LaptopsAndNotebookTest extends BaseTest {
	
	HomePage page;
	LaptopsAndNotebooksPage lanp;

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
	public void verifyLaptopsAndNotebookPageHeaderText() {
		Log.startTestCase("verifyLaptopsAndNotebookPageHeaderText");
		page = new HomePage();
		lanp = new LaptopsAndNotebooksPage();
		Log.info("User clicks on My Account Link");
		page.hoverOnLaptopsAndNotebooks();
		Log.info("User clicks on LaptopsAndNotebooks link");
		page.clickOnAllLaptopsAndNotepadsLink();
		
		String ExpectedResults = prop.getProperty("headerText");
		String actualResults = lanp.getAllLaptopsAndNotebooksHeaderText();
		Log.info("User is verifying if success header message is present");
		Assert.assertEquals(ExpectedResults, actualResults);
		Log.endTestCase("verifyLaptopsAndNotebookPageHeaderText");
		
	}
	
}
