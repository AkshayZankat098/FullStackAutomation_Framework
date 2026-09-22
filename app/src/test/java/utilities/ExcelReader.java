package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String FILE_PATH =
            "B:\\Akshay Automation\\SDET_Framework\\FullStackAutomation_Framework\\app\\src\\test\\resources\\TestData\\User Module APIs Test Cases.xlsx";

    private static final String SHEET_NAME = "Test Cases";

    public static Object[][] getTestData() {

        try (Workbook wb = new XSSFWorkbook(new FileInputStream(FILE_PATH))) {

            Sheet sheet = wb.getSheet(SHEET_NAME);
            DataFormatter formatter = new DataFormatter();

            int columns = sheet.getRow(0).getLastCellNum();
            List<Object[]> data = new ArrayList<>();

            for (Row row : sheet) {

                if (row.getRowNum() == 0 ||
                    row.getCell(0) == null ||
                    formatter.formatCellValue(row.getCell(0)).trim().isEmpty()) {
                    continue;
                }

                Object[] values = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    Cell cell = row.getCell(i);
                    values[i] = cell == null ? "" : formatter.formatCellValue(cell);
                }

                data.add(values);
            }

            return data.toArray(new Object[0][]);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read Excel: " + FILE_PATH, e);
        }
    }
}