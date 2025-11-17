package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider (name = "LoginData")

    public String [][] getData() throws IOException {
        String path = ".\\data\\loginUserDetails.xlsx";
        ExcelUtility excelUtility = new ExcelUtility(path);
        int totalRowCount = excelUtility.getRowCount ("Sheet1");
        int totalCellCount = excelUtility.getCellCount("Sheet1",1);
        String loginData [][]=new String [totalRowCount][totalCellCount];

        for (int i=1; i<=totalRowCount;i++)
        {
            for (int j=0;j<totalCellCount;j++)
            {
                loginData[i-1][j]=excelUtility.getCellValue("Sheet1",i,j);
            }
        }
       return loginData;
    }
}
