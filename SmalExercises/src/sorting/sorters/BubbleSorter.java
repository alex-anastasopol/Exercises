package Sorters;

public class BubbleSorter implements Sorter {

	@Override
	public void sort(Integer[] n) {
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < n.length - 1; i++) {
				if (n[i + 1] == null) {
					throw new IllegalArgumentException("Null values are not allowed ");
				}

				if (n[i + 1] < n[i]) {
					swapValues(n, i, i + 1);
					swapped = true;
				}

			}
		} while (swapped);
	}
}
