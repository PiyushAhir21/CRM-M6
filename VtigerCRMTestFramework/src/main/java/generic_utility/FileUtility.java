package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
//		Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\VtigerCRMM6\\VtigerCRMTestFramework\\src\\test\\resources\\commonData.properties");

//		fetch keys, by using load method of Properties class
		Properties pObj = new Properties();
		pObj.load(fis);

//		get values, by using getProperty method
		String Value = pObj.getProperty(key);
		return Value;
	}
	
	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
