package Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RandomNumberGenerator {
	public static Integer[] generateInts(int count) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			arrayList.add(i);
		}

		Collections.shuffle(arrayList);
		return (Integer[]) arrayList.toArray(new Integer[1]);
	}

	public static String generateIntsAndReturnString(int count) {
		return Arrays.deepToString(generateInts(count));
	}

	public static void main(String[] args) {

	}
}
