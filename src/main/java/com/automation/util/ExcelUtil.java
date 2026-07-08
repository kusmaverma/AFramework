package com.automation.util;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String getCellData(
			String sheetName,
			int rowNum,
			int colNum) {

		String value = "";

		try {

			InputStream fis =
					ExcelUtil.class
							.getClassLoader()
							.getResourceAsStream(
									"TestData.xlsx");

			if (fis == null) {

				throw new RuntimeException(
						"TestData.xlsx not found");
			}

			XSSFWorkbook workbook =
					new XSSFWorkbook(fis);

			XSSFSheet sheet =
					workbook.getSheet(sheetName);

			Row row =
					sheet.getRow(rowNum);

			Cell cell =
					row.getCell(colNum);

			value =
					cell.toString();

			workbook.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return value;
	}

	public static Object[][] getTestData(
			String sheetName) {

		Object[][] data = null;

		try {

			InputStream fis =
					ExcelUtil.class
							.getClassLoader()
							.getResourceAsStream(
									"TestData.xlsx");

			if (fis == null) {

				throw new RuntimeException(
						"TestData.xlsx not found");
			}

			XSSFWorkbook workbook =
					new XSSFWorkbook(fis);

			XSSFSheet sheet =
					workbook.getSheet(sheetName);

			int rowCount =
					sheet.getLastRowNum();

			int colCount =
					sheet.getRow(0).getLastCellNum();

			data =
					new Object[rowCount][colCount];

			for (int i = 1; i <= rowCount; i++) {

				for (int j = 0; j < colCount; j++) {

					data[i - 1][j] =
							sheet.getRow(i)
									.getCell(j)
									.toString();
				}
			}

			workbook.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}
}