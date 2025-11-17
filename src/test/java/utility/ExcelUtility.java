package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    public FileInputStream fi;
    public XSSFWorkbook wb;
    public XSSFSheet ws;
    public XSSFRow row;
    public XSSFCell column;
    String path;

    public ExcelUtility (String path)
    {
        this.path=path;
    }

    public int getRowCount(String xlSheet) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String xlsSheet, int rowCount) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsSheet);
        row = ws.getRow(rowCount);
        int cellCount = row.getLastCellNum();
        wb.close ();
        fi.close ();
        return cellCount;
    }

    public String getCellValue(String xlsSheet, int rowNum, int colNum) throws IOException {
      fi = new FileInputStream (path);
      wb = new XSSFWorkbook(fi);
      ws = wb.getSheet(xlsSheet);
      row = ws.getRow(rowNum);
      column = row.getCell(colNum);

      String data;
      try
      {
          data = column.toString();
      }
      catch ( Exception e)
      {
          data ="";
      }
      wb.close();
      fi.close();
      return data;
    }
}