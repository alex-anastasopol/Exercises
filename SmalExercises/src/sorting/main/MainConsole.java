package Main;

import java.util.Arrays;

import Sorters.BubbleSorter;
import Sorters.InsertionSorter;
import Sorters.MergeSorter;
import Sorters.SelectionSorter;
import Sorters.Sorter;

public class MainConsole {
	static Integer[] values = { 7, 5, 4, 32, 32, 35, 65, 7, 84, 4, 54, 736, 2, 6985, 537, 45, 44, 67, 7, 8, 76, 4, 3, 6,
			44, 34, 2, 22, 2, 32, 32, 7, 89, 0, 97, 87, 752, 723, 25, 57, };
//	 static Integer[] values = { 13, 7, 3 };

	public static void main(String[] args) {
		// Sorter sorter = new BubbleSorter();
		// Sorter sorter = new SelectionSorter();
		//Sorter sorter = new InsertionSorter();
		Sorter sorter = new MergeSorter();
		System.out.println("Values BEFORE sorting:" + Arrays.toString(values));
		sorter.sort(values);
		System.out.println("Values AFTER sorting:" + Arrays.toString(values));
		String s = new String();
	}
}
