package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static Properties prop;
	Action action;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig() {  
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public String randomString() {

		String generateRandom = RandomStringUtils.randomAlphanumeric(9);
		return generateRandom;
	}

	public String randomNumeric() {

		String generateRandom = RandomStringUtils.randomNumeric(7);
		return generateRandom;
	}

	public String generateString()
	{
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		return generatedString;
	}
	
	public void launchApp(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver()); 
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
 		action = new Action(); 
		action.implicitWait(getDriver(), 10);
		action.pageLoadTimeOut(getDriver(), 30);	
		
	}
	
	@AfterSuite
	public void afterSuit() {
		ExtentManager.endReport();
	}
}
