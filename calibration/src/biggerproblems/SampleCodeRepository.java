package biggerproblems;

import java.util.ArrayList;
import java.util.List;

public class SampleCodeRepository {
	
	public static void main(String[] args) {
		List<Integer> row1 = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++)
			row1.add(i);
		List<Integer> row2 = new ArrayList<Integer>();
		for (int i = 9; i < 18; i++)
			row2.add(i);
		List<Integer> row3 = new ArrayList<Integer>();
		for (int i = 18; i < 27; i++)
			row3.add(i);
		List<List<Integer>> classroom = new ArrayList<List<Integer>>();
		classroom.add(row1);
		classroom.add(row2);
		classroom.add(row3);
		System.out.println(classroom);
	}

}
