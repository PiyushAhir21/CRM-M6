package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataBackToPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\git\\VtigerCRMM6\\VtigerCRMTestFramework\\src\\test\\resources\\commonData2.properties");
		
		Properties pObj = new Properties();
		pObj.setProperty("a1", "Jethalal");
		pObj.setProperty("b1", "gada");
		pObj.setProperty("c", "champaklal");
		pObj.setProperty("d", "Gada electronics");
		
//		Save 
		pObj.store(fos, "Data added");
		
		System.out.println("data added successfully");
	}
}