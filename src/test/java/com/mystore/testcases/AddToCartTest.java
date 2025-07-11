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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LaptopsAndNotebooksPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.ProductAddedToCartPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class AddToCartTest extends BaseTest {
	
	HomePage page;
	LoginPage lp;
	LaptopsAndNotebooksPage lanp;
	AddToCartPage atcp;
	ProductAddedToCartPage patcp;
	
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
			dataProvider = "ProductCredentials",
			dataProviderClass = DataProviders.class)
	public void verifyItemAddedToCart(
			String email, 
			String pass, 
			String deliveryDate,
			String quantity,
			String headerText
			) throws InterruptedException {
		Log.startTestCase("verifyItemAddedToCart");
		page = new HomePage();
		lp = new LoginPage();
		lanp = new LaptopsAndNotebooksPage();
		atcp = new AddToCartPage();
		patcp = new ProductAddedToCartPage();
		Log.info("User clicks on My Account Link");
		page.clickMyaccountLink();
		Log.info("User clicks on login Link");
		page.clickLoginLink();
		Log.info("User enters credentials and click sign in");
		lp.login(email, pass);
		Log.info("User hover on LaptopsAndNotebooks link");
		page.hoverOnLaptopsAndNotebooks();
		Log.info("User clicks on LaptopsAndNotebooks link");
		page.clickOnAllLaptopsAndNotepadsLink();
		Log.info("User click on the item to add to cart");
		lanp.clickAddToCartItem();
		Log.info("User enters delivery date, quantity and click on add to cart button");
		atcp.enterAvailableOptions(deliveryDate, quantity);
		
		String actualResult = headerText;
		String expectedResult = patcp.getAddToCartSuccessHeaderMessage();
		Log.info("User is verifying if success header message is present");
		Assert.assertEquals(expectedResult, actualResult);
		Log.endTestCase("verifyItemAddedToCart");
		
	}
	

}
