package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		Step - 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		
//		Step - 2> get the access of WorkBook, by using create() of WBF
		Workbook wb = WorkbookFactory.create(fis);
		
		String orgName = wb.getSheet("org").getRow(3).getCell(1).getStringCellValue();
		String firstname = wb.getSheet("contact").getRow(4).getCell(1).getStringCellValue();
		System.out.println(orgName);
		
		
//		step - 3> get the access of sheet, by using getSheet()
//		Sheet sh = wb.getSheet("org");
		
//		Step - 4> get the access of row, by using getRow()
//		Row row = sh.getRow(3);
		
//		Ṣtep - 5> Get the access of cell, by using getCell()
//		Cell cell = row.getCell(0);
		
//		Step - 6> Get the data, by using getStringCellValue()
//		String orgName = wb.getSheet("org").getRow(3).getCell(0).getStringCellValue();
//		System.out.println(orgName);
//		cell.getNumericCellValue();
//		cell.getBooleanCellValue();
//		cell.getLocalDateTimeCellValue();
		
	}
}
