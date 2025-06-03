package extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoForDataProvider {

	@Test(dataProvider = "getData")
	public void recieve(String firstname, String lastName) {
		System.out.println(firstname);
		System.out.println(lastName);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object students[][] = new Object[3][2];
		students[0][0] = "Akash";
		students[0][1] = "Mishra";

		students[1][0] = "Bharti";
		students[1][1] = "-";

		students[2][0] = "Harmanjit";
		students[2][1] = "kaur";

		return students;
	}
}
