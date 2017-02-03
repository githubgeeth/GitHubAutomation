/** 
* Test Script Id : ExcelReader
* Author : Subbareddy Changa
* Version : V1.0
* Reviewed By : Subbareddy Changa
* Date of Creation : January 24, 2017
*/
package functionLibraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Class Description: This class contains a method to read input data from Excel
 * Sheet.
 */

public class ExcelReader {

	/**
	 * This method is used to read input data from an excel sheet.
	 * 
	 * @param sheet
	 *            sheet name where the input data is stored for a scenario.
	 * @param x
	 *            column number from which the input is read from a cell in the
	 *            Excel sheet.
	 * @param y
	 *            row number from which the input is read from a cell in the
	 *            Excel sheet.
	 * @return string value in the column 'x' and row 'y' of the Excel sheet.
	 * @throws Exception
	 *             if an input exception occurred.
	 */
	public String getData(String sheet, int x, int y) throws Exception {

		Sheet s;

		String data;

		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\Input\\EA_TestData.xlsx");
		Workbook W = WorkbookFactory.create(fi);
		DataFormatter formatter = new DataFormatter(); 
		
		s = W.getSheet(sheet);

		Row row = s.getRow(y);
		Cell iSysName = row.getCell(x);

		data = formatter.formatCellValue(iSysName);

		return data;
	}

}