package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Utility class to handle file operations such as reading data from properties
 * files and Excel spreadsheets.
 * 
 * <p>
 * This class provides methods to fetch configuration values from a properties
 * file and test data from an Excel file, commonly used in test automation
 * frameworks.
 * </p>
 * 
 * @author Piyush Baldaniya
 * @version 1.0
 */
public class FileUtility {

	/**
	 * Reads a value from the properties file corresponding to the given key.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the value corresponding to the key in the properties file
	 * @throws IOException if an I/O error occurs while reading the properties file
	 */
	public String getDataFromPropertiesFile(String key) throws IOException {
		// Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\VtigerCRMM6\\VtigerCRMTestFramework\\src\\test\\resources\\commonData.properties");

		// Fetch keys by loading the properties file
		Properties pObj = new Properties();
		pObj.load(fis);

		// Get values by using getProperty method
		String value = pObj.getProperty(key);
		fis.close(); // Close stream to avoid resource leak
		return value;
	}

	/**
	 * Reads the data from the specified Excel sheet, row, and cell.
	 * 
	 * @param sheetName the name of the sheet from which to read data
	 * @param rowNum    the row number (0-based index)
	 * @param cellNum   the cell number (0-based index)
	 * @return the String value present in the specified cell
	 * @throws EncryptedDocumentException if the Excel file is encrypted and cannot
	 *                                    be read
	 * @throws IOException                if an I/O error occurs while reading the
	 *                                    Excel file
	 */
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();		// Close workbook to prevent memory leaks
		return value;
	}
}
