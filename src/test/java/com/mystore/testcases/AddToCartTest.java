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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LaptopsAndNotebooksPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.ProductAddedToCartPage;

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
		page.clickMyaccountLink();
		page.clickLoginLink();
		lp.login(prop.getProperty("email"),
				prop.getProperty("password"));
		page.hoverOnLaptopsAndNotebooks();
		page.clickOnAllLaptopsAndNotepadsLink();
		lanp.clickAddToCartItem();
		
		atcp.enterAvailableOptions(prop.getProperty("deliveryDate"),
				prop.getProperty("quantity"));
		
		String actualResult = prop.getProperty("addToCartSuccessMsg");
		String expectedResult = patcp.getAddToCartSuccessHeaderMessage();
		System.out.println(actualResult + " = " + expectedResult);
		Assert.assertEquals(expectedResult, actualResult);
		
	}
	

}
