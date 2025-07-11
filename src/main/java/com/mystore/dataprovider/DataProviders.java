package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj;
	
	public DataProviders() {
		
		obj = new NewExcelLibrary();
	}
	@DataProvider(name = "registration")
	public Object[][] getRegistration() {
		// Totals rows count
		int rows = obj.getRowCount("RegistrationDetails");
		// Total Columns
		int column = obj.getColumnCount("RegistrationDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("RegistrationDetails", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "loginCredentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("LoginCredentials");
		// Total Columns
		int column = obj.getColumnCount("LoginCredentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("LoginCredentials", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "ProductCredentials")
	public Object[][] getCartItemDetails() {
		// Totals rows count
		int rows = obj.getRowCount("AddToCart");
		// Total Columns
		int column = obj.getColumnCount("AddToCart");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("AddToCart", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "addToCart")
	public Object[][] getCartPrice() {
		// Totals rows count
		int rows = obj.getRowCount("AddToCart");
		// Total Columns
		int column = obj.getColumnCount("AddToCart");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("AddToCart", j, i + 2);
			}
		}
		return data;
	}


}
