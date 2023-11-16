package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelReader {

    public static FileInputStream fis;

    public ExcelReader() {
    }

    public FileInputStream getFileInputStream() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\New Microsoft Excel Worksheet (2).xlsx";
        File src=new File(filePath);
        fis=new FileInputStream(src);
        return fis;
    }

    public Object[][]getExcelData() throws IOException {

        fis=getFileInputStream();
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int totalNumberOfRows=(sheet.getLastRowNum()+1);
        int totalNumberOfColumns=4;
        String[][]arrayExcelData=new String[totalNumberOfRows][totalNumberOfColumns];
        for (int i=0;i<totalNumberOfRows;i++)
        {
            for (int j=0;j<totalNumberOfColumns;j++)
            {
                XSSFRow row=sheet.getRow(i);
                arrayExcelData[i][j]=row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;




    }
}
