package practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\Downloads\\TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows: " + totalRows);
        Row row;
        row = sheet.getRow(0);

        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("Total Columns: " + totalColumns);

        for (int i = 1; i < totalRows; i++){
            row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++){
                Cell cell = row.getCell(j);

                String val = cell.getStringCellValue();
                System.out.println(val + " ");
            }
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }
}
