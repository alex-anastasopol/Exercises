package Sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import Utilities.SorterFactory;
import Utilities.SorterFactory.SorterType;

public class SorterTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentExceptionForNulls() {
		Integer[] values = { 11, 3, 44, null, 6 };
		Sorter sorter = new BubbleSorter();
		sorter.sort(values);
	}

	@Test
	public void test30RandomElementsAreSortedAscending() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			arrayList.add(i);
		}

		Collections.shuffle(arrayList);
		Integer[] properlySortedArray = arrayList.toArray(new Integer[0]);

		for (SorterType method : SorterType.values()) {
			Integer[] arrayToCheckIfProperlySorted = sort(properlySortedArray, method);
			Arrays.sort(properlySortedArray);
			Assert.assertArrayEquals(properlySortedArray, arrayToCheckIfProperlySorted);
		}
	}

	private Integer[] sort(Integer[] initial_array, SorterType sorterType) {
		Integer[] sorted_array = Arrays.copyOf(initial_array, initial_array.length);
		SorterFactory.getSorter(sorterType).sort(sorted_array);
		return sorted_array;
	}

	private Sorter getSorter(SorterType method) {
		Sorter sorter;
		switch (method) {

		case BUBBLE:
			sorter = new BubbleSorter();
			break;

		case SELECTION:
			sorter = new SelectionSorter();
		case INSERTION:
			sorter = new InsertionSorter();
		case MERGE:
			sorter = new MergeSorter();

			// TODO: add the other sorting methods when implemented
		default:
			sorter = new BubbleSorter();

		}
		return sorter;
	}
}
