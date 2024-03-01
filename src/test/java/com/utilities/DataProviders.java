package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "Data")
	public static String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";// taking xl file from testData

		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String apidata[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																// data username and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from xl storing in two deminsional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
			{
				apidata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return apidata;// returning two dimension array

	}

	// DataProvider 2
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);

		int rownum = xl.getRowCount("Sheet1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);

		}

		return apidata;
	}
	// DataProvider 3

	// DataProvider 4
}
