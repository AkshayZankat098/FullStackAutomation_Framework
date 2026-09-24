package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private static final String FILE_PATH =
            "B:\\Akshay Automation\\SDET_Framework\\FullStackAutomation_Framework\\app\\src\\test\\resources\\TestData\\Pre-Order Meals APIs Test Cases.xlsx";

    private static final String SHEET_NAME = "Test Cases GET";

    public static Object[][] getTestData() {

        try (Workbook wb = new XSSFWorkbook(new FileInputStream(FILE_PATH))) {

            Sheet sheet = wb.getSheet(SHEET_NAME);
            DataFormatter f = new DataFormatter();

            Row header = sheet.getRow(0);
            int columns = header.getLastCellNum();

            List<Object[]> data = new ArrayList<>();

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {

                Row row = sheet.getRow(r);
                if (row == null || f.formatCellValue(row.getCell(0)).trim().isEmpty())
                    continue;

                Map<String, String> map = new LinkedHashMap<>();

                for (int c = 0; c < columns; c++) {

                    String key = f.formatCellValue(header.getCell(c)).trim();

                    if (!key.isEmpty()) {
                        String value = row.getCell(c) == null
                                ? ""
                                : f.formatCellValue(row.getCell(c)).replace(",", "").trim();

                        map.put(key, value);
                    }
                }

                data.add(new Object[]{map});
            }

            return data.toArray(new Object[0][]);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read Excel: " + FILE_PATH, e);
        }
    }
}