package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		Step - 1> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		
//		Step - 2> get the access of WorkBook, by using create() of WBF
		Workbook wb = WorkbookFactory.create(fis);
			
		
//		step - 3> get the access of sheet, by using getSheet()
		Sheet sh = wb.getSheet("org");
		
//		Step - 4> get the access of row, by using getRow()
		Row row = sh.getRow(3);
		
//		Ṣtep - 5> Get the access of cell, by using createCell()
		Cell cell = row.getCell(4);
		
//		Step - 6> Write Data into that cell
		cell.setCellType(CellType.STRING);
		cell.setCellValue("hi there");
		
//		Save
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Desktop\\testScriptDataM6.xlsx");
		wb.write(fos);
		
		System.out.println("Data added successfully!!!");
		wb.close();
		
	}
}
