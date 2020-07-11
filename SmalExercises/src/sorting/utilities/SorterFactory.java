package Utilities;

import Sorters.BubbleSorter;
import Sorters.InsertionSorter;
import Sorters.MergeSorter;
import Sorters.SelectionSorter;
import Sorters.Sorter;

public class SorterFactory {

	public static enum SorterType {
		BUCKET, BUBBLE, INSERTION, SELECTION, HEAP, MERGE
	};

	public static Sorter getSorter(SorterType sorterType) {
		switch (sorterType) {
		case BUBBLE:
			return new BubbleSorter();
		case INSERTION:
			return new InsertionSorter();
		case SELECTION:
			return new SelectionSorter();
		case MERGE:
			return new MergeSorter();
		default:
			return new BubbleSorter();
		}
	}
}
