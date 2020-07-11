package Sorters;

public class InsertionSorter implements Sorter {
	
	@Override
	public void sort(Integer[] array) {

		for (int i = 1; i < array.length; i++) {
			int index = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > index) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = index;
		}
	}
}
