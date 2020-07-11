package Sorters;

public interface Sorter {

	public void sort(Integer[] array);

	public default void swapValues(Integer[] array, int i, int j) {
		array[i] += array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
}
