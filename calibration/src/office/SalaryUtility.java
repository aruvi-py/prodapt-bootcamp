package office;

import java.util.ArrayList;
import java.util.List;

public class SalaryUtility {
	
	public double computeGroupASalary(float basic, float tdsRate) {
		return basic - basic * tdsRate / 100;
	}
	
	public double computeGroupBSalary(float hourly, int hours, float tdsRate) {
		return hourly * hours - hourly * hours * tdsRate / 100;
	}
	
	public double computeCEOSalary(float tdsRate) {
		return (float) Integer.MAX_VALUE - (float) Integer.MAX_VALUE * tdsRate / 100;
	}
	
	public String findGroup(String record) {
		//some processing
		return "A";
	}
	
	public static void main(String[] args) {
		List<String> employeeRecords = new ArrayList<String> ();
		for (String employee : employeeRecords) {
			//switch()
			//case A: call computeGroupASalary
			//case B: ....
			//adn so on.
		}
	}

}
