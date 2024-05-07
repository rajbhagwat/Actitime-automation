package practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling1 {
    FileInputStream inputStream;
    Workbook workbook;

    //get the control of workbook
    public Workbook getWorkbook(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        System.out.println(extension);

        //access the file
        inputStream = new FileInputStream(file);
        //access the workbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xlx")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    //get the exel data
    @DataProvider
    public Object[][] getExcelData() throws Exception {
        Workbook workbook = getWorkbook("C:\\Users\\DELL\\Downloads\\TestData.xlsx");
        //access 0th index sheet
        Sheet sheet = workbook.getSheetAt(0);
        //get total no of rows
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows: " + totalRows);
        //get total num of columns
        Row row;
        row = sheet.getRow(0);
        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("Total Columns: " + totalColumns);

        Object[][] data = new Object[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            //get the access of each row based on the value of i
            row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++) {
                Cell cell = row.getCell(j);
                Object var = null;
                if (cell.getCellType()!=null){
                    switch (cell.getCellType()) {
                        case STRING:
                            var = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            var = cell.getNumericCellValue();
                            break;
                        case BLANK:
                            break;
                        case BOOLEAN:
                            var = cell.getBooleanCellValue();
                            break;
                    }
                    data[i - 1][j] = var;
                    System.out.print(var + " ");
                }
            }
            System.out.println();
        }
        return data;
    }

    //close workbook and fileInputStream instances
    public void closeInstances() throws IOException {
        //close workbook
        workbook.close();
        //close file
        inputStream.close();
    }

    @Test(dataProvider = "getExcelData")
    public void verifyExelData(Object var1, Object var2) {
        System.out.println(var1 + " " + var2);
    }

    @AfterTest
    public void tearDown() throws IOException {
        closeInstances();
    }
}
