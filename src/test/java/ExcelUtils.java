

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    //private static XSSFSheet ExcelWSheet;
    private static HSSFSheet ExcelWSheet;
    //private static XSSFWorkbook ExcelWBook;
    private static HSSFWorkbook ExcelWBook;
    //private static XSSFCell cell;
    private static HSSFCell cell;
    private static XSSFRow Row;

    public static void main(String[] args) throws Exception {

        getTableArray("C:\\Users\\pjuncodi\\Downloads\\Consulta_ financiamientos.xls", "Page 1");
    }

    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;


        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new HSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 8;
            int startCol = 2;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            int totalCols = ExcelWSheet.getRow(0).getLastCellNum() - 1;

            // you can write a function as well to get Column count

            //int totalCols = 5;
            tabArray = new String[totalRows][totalCols];
            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j <= totalCols; j++, cj++) {

                    tabArray[ci][cj] = readData(i, j);
                    //System.out.println(tabArray[ci][cj]);
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();

        }
        eliminarFila(1,tabArray);
        mostrarMatriz(tabArray);
        return (tabArray);

    }

    public static boolean setCellData(String FilePath, String SheetName, int RowNum, int ColNum, String dato) throws Exception {
        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new HSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            FileOutputStream out = new FileOutputStream(new File(FilePath));
            return writeData(RowNum, ColNum, dato, out);

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            return false;
        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            return false;
        }
    }

    public static String getCellData(String FilePath, String SheetName, int RowNum, int ColNum) throws Exception {
        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new HSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            return readData(RowNum, ColNum);

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            return "false";
        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            return "false";

        }
    }


    private static String readData(int RowNum, int ColNum) throws Exception {

        try {

            cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int dataType = cell.getColumnIndex();

//            if (dataType == 3) {
//                return "";
//            } else {
            String CellData = cell.getStringCellValue();
            return CellData;
            //}
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }

    }

    private static boolean writeData(int RowNum, int ColNum, String dato, FileOutputStream out) {

        try {

            // cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            cell = ExcelWSheet.createRow(RowNum).createCell(ColNum);
            int dataType = cell.getColumnIndex();

            cell.setCellValue(dato);

            ExcelWBook.write(out);
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
            // throw (e);
        }

    }

    public static void mostrarMatriz(String[][] info) {
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                System.out.println(info[i][j]);
            }
        }
    }
    public static String[][] eliminarFila(int numeroFila, String[][] info) {
        String[][] nuevaMatriz = new String[info.length-1][info[0].length];
        int contador = 0;

        for(int filaActual=0; filaActual<info.length; filaActual++) {
            for(int columnaActual=0; columnaActual<info[0].length; columnaActual++) {
                if(numeroFila==filaActual) {
                    filaActual++;
                }

                nuevaMatriz[contador][columnaActual]= info[filaActual][columnaActual];
            }
            contador++;
        }

        return nuevaMatriz;
    }
}

