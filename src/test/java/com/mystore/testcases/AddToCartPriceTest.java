package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseTest;
import com.mystore.pageobjects.AccountPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LaptopsAndNotebooksPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.ProductAddedToCartPage;
import com.mystore.utility.Log;

public class AddToCartPriceTest extends BaseTest {
	
	HomePage page;
	LoginPage lp;
	LaptopsAndNotebooksPage lanp;
	AddToCartPage atcp;
	ProductAddedToCartPage patcp;
	AccountPage ap;

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
	public void verifyItemAddedToCart() throws InterruptedException {
		
		page = new HomePage();
		lp = new LoginPage();
		lanp = new LaptopsAndNotebooksPage();
		atcp = new AddToCartPage();
		patcp = new ProductAddedToCartPage();
		ap = new AccountPage();
		Log.startTestCase("verifyItemAddedToCart");
		Log.info("User clicks on My Account");
		page.clickMyaccountLink();
		Log.info("User clicks on login link");
		page.clickLoginLink();
		Log.info("User enters credentials and sign-in");
		//lp.login(email, pass);
		lp.login(prop.getProperty("email"), prop.getProperty("password"));
		ap.clickAddToCartButtonPrice();
		Log.info("User hover on LaptopsAndNotebooks link");
		page.hoverOnLaptopsAndNotebooks();
		Log.info("User clicks on LaptopsAndNotebooks link");
		page.clickOnAllLaptopsAndNotepadsLink();
		Log.info("User add to cart delivery date,quantity and clicks on add to cart");
		
		lanp.clickAddToCartItem();
		
		atcp.enterAvailableOptions(prop.getProperty("deliveryDate"),
				prop.getProperty("quantity"));
		String quantity = prop.getProperty("quantity");
		String itemPrice = prop.getProperty("itemPrice");
		
		double expectedTotal = Integer.parseInt(quantity) * Double.parseDouble(itemPrice);
		String expectedFomattedTotalPrice = String.format("%.2f", expectedTotal);
		double totalFromCart = atcp.getTotal();
		String actualFomattedTotalPriced = String.format("%.2f", totalFromCart);
		
		Assert.assertEquals(actualFomattedTotalPriced, expectedFomattedTotalPrice);
		Log.endTestCase("verifyItemAddedToCart");
		
	}
		
}
