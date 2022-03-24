import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFor {


    public static void main(String[] args) throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File("C:\\Users\\pjuncodi\\Downloads\\Consulta_ financiamientos.xls");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        //XSSFWorkbook  wb = new XSSFWorkbook(inputStream);

        //creating a Sheet object
        HSSFSheet sheet = wb.getSheet("Page 2");
        //XSSFSheet sheet= wb.getSheet("Hoja1");

        //get all rows in the sheet
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //iterate over all the row to print the data present in each cell.
        for (int i = 8; i <= rowCount; i++) {

            //get cell count in a row
            int cellcount = sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row" + i + " data is :");

            for (int j = 2; j < cellcount; j++) {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "|");
            }
            System.out.println();
        }
    }
}
