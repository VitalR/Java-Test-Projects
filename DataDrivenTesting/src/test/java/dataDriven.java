import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public ArrayList<String> getData(String testcaseName) throws IOException {

        //file input stream argument
        ArrayList<String> argument = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("/Users/agileengine/ExcelDriven/demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify Testcases column by scanning the entire 1st row

                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> cells = firstrow.cellIterator(); //row is collection of cells
                int k = 0;
                int column = 0;
                while (cells.hasNext()) {
                    Cell value = cells.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
                        column = k;

                    }
                    k++;
                }
                //System.out.println(column);

                //once column is identified then scan entire testcase column to identify purchase testcase row
                while (rows.hasNext()) {
                    Row row = rows.next();
                    row.getCell(column);
                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        //after you grab purchase testcase row = pull of the data of that row and feed into test

                        Iterator<Cell> cv = row.cellIterator();
                        while (cv.hasNext()) {
                            System.out.println(cv.next().getStringCellValue());
                            argument.add(cv.next().getStringCellValue());
                        }

                    }
                }
            }
        }
        return argument;
    }

    public static void main(String[] args) {


    }

}
