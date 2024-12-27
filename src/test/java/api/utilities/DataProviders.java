package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//api_testdata_datadriven.xlsx"; // taking file from test data
		
		XLUtilities utilities= new XLUtilities(path);  // utility object
		
		int totalRows=utilities.getRowCount("Sheet1");
		int totalColumns=utilities.getColCount("Sheet1", 1);
		
		String apidata [][]= new String [totalRows][totalColumns]; // 2 dimensional array to store data
		
		for(int i=1;i<=totalRows;i++)  // 1 reading data from Excel and storing data in 2d array
		{
			for(int j=0;j<totalColumns;j++) // 0  
			{
				apidata[i-1][j]=utilities.getCellData("Sheet1", i, j);  // 1,0 
			}
		}
		       
	  return apidata;
		
	}
	
	
		
		@DataProvider(name="UserNames")
		public String [] getUserData() throws IOException
         {
	
			String path=System.getProperty("user.dir")+"//testData//api_testdata_datadriven.xlsx"; // taking file from test data
			
			XLUtilities utilities= new XLUtilities(path);  // utility object
			
			int totalRows=utilities.getRowCount("Sheet1");
			
			String apiData[]=new String[totalRows];
			
			for(int i=1;i<=totalRows;i++)
			{
				apiData[i-1]=utilities.getCellData("sheet1", i, 1);
			}
			
			return apiData;
		}
		
}


