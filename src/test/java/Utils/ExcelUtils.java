
package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getExcelData(String filePath) throws IOException {

		try (FileInputStream file = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(file)) {

			Sheet sheet = workbook.getSheet("Sheet1");

			int totalRows = sheet.getLastRowNum();
			Object[][] data = new Object[totalRows][3];

			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i <= totalRows; i++) {
				Row row = sheet.getRow(i);

				for (int j = 0; j < 3; j++) {
					data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
				}
			}

			return data;
		}
	}
}
