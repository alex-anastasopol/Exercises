package Sorters;

public class SelectionSorter implements Sorter {
	@Override
	public void sort(Integer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (min != i) {
				swapValues(array, i, min);
			}
		}

	}
}
