package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="logindata")
	public String [][] getData() throws IOException{
			
		String path = "/Users/aloktiwari/eclipse-workspace/OpenCart_V1.0/testData/Opencart_LoginData.xlsx";
		
		ExcelUtility xlutility = new ExcelUtility(path);
		
		int rowCount = xlutility.getRowCount("sheet1");
		int cellCount = xlutility.getCellCount("sheet1", 1);
		
		String loginData [][] = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			
			for(int j=0; j<cellCount; j++) {
				loginData [i-1][j] = xlutility.getCellData("sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
