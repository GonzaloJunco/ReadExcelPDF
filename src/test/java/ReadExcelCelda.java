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

public class ReadExcelCelda {

    public static void main(String[] args) throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File("C:\\Users\\pjuncodi\\Downloads\\Consulta_ financiamientos.xls");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //Creating workbook instance that refers to .xls file
        HSSFWorkbook wb =new HSSFWorkbook(inputStream);
        //XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        HSSFSheet sheet=wb.getSheet("Page 1");
        //XSSFSheet sheet = wb.getSheet("Hoja1");

        //Create a row object to retrieve row at index 1
        HSSFRow row2=sheet.getRow(12);
        //XSSFRow row2 = sheet.getRow(12);

        //Create a cell object to retreive cell at index 5
        HSSFCell cell = row2.getCell(2);
        //XSSFCell cell = row2.getCell(3);

        //Get the address in a variable
        String address = cell.getStringCellValue();

        //Printing the address
        System.out.println("Address is : " + address);
    }
}
