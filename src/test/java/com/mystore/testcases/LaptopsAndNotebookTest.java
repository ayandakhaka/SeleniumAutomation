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

/**
 * 
 */
public class LaptopsAndNotebookTest extends BaseTest {
	
	HomePage page;
	LaptopsAndNotebooksPage lanp;

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
	public void verifyLaptopsAndNotebookPageHeaderText() {
		page = new HomePage();
		lanp = new LaptopsAndNotebooksPage();
		
		page.hoverOnLaptopsAndNotebooks();
		page.clickOnAllLaptopsAndNotepadsLink();
		
		String ExpectedResults = prop.getProperty("headerText");
		String actualResults = lanp.getAllLaptopsAndNotebooksHeaderText();
		
		Assert.assertEquals(ExpectedResults, actualResults);
	}
	
}
