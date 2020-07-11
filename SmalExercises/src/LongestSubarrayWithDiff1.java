import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestSubarrayWithDiff1 {

	static int longestSubarray(List<Integer> array) {
		int longest = 1;
		int current = 1;

		int firstIdxVal = 0;
		int subarrayDifference = 0;
		int highestSubarrDiff = 0;
		int i = 0;
		System.out.println("array:" + array);
		while (i < array.size() - 1) {
			System.out.println("before while execute: firstIdxVal=" + firstIdxVal + ", subarrayDifference="
					+ subarrayDifference + ", current=" + current + ", i=" + i);
			i++;

			boolean increment = false;

			if (array.get(firstIdxVal) == array.get(i)) {
				increment = true;
			} else if (array.get(firstIdxVal) - array.get(i) == 1) {
				if (subarrayDifference == 0) {
					subarrayDifference = 1;
				}

				if (subarrayDifference == 1) {
					increment = true;
				}

			} else if (array.get(firstIdxVal) - array.get(i) == -1) {
				if (subarrayDifference == 0) {
					subarrayDifference = -1;
				}
				if (subarrayDifference == -1) {
					increment = true;
				}
			}

			if (increment) {
				current++;
				if (current > longest) {
					longest = current;
					highestSubarrDiff = subarrayDifference;
				}
				System.out.println("while - after increment = true: firstIdxVal=" + firstIdxVal
						+ ", subarrayDifference=" + subarrayDifference + ", current=" + current + ", i=" + i);
			} else {
				current = 1;
				firstIdxVal = i;
				subarrayDifference = 0;
				System.out.println("while - after increment = false: firstIdxVal=" + firstIdxVal
						+ ", subarrayDifference=" + subarrayDifference + ", current=" + current + ", i=" + i);
			}
		}

		boolean increment = false;
		if (firstIdxVal > 0) {
			if (array.get(firstIdxVal) == array.get(firstIdxVal - 1)) {
				increment = true;
			} else if (array.get(firstIdxVal) - array.get(firstIdxVal - 1) == 1) {
				if (highestSubarrDiff == 0) {
					highestSubarrDiff = 1;
				}

				if (highestSubarrDiff == 1) {
					increment = true;
				}

			} else if (array.get(firstIdxVal) - array.get(firstIdxVal - 1) == -1) {
				if (highestSubarrDiff == 0) {
					highestSubarrDiff = -1;
				}
				if (highestSubarrDiff == -1) {
					increment = true;
				}
			}
		}
		if (increment) {
			longest = longest + 1;
		}
		return longest;
	}

	public static void main(String[] args) {
//		List<Integer> array = new ArrayList<Integer>();
//
//		Scanner sc = new Scanner(System.in);
//		int length = sc.nextInt();
//		for (int i = 0; i < length; i++) {
//			int val = Integer.parseInt(sc.nextLine().trim());
//			array.add(val);
//		}
//
//		LongestSubarrayWithDiff1.longestSubarray(array);
//		

		List<Integer> array = Stream.of(0, 1, 2, 2, 2, 2, 2).collect(Collectors.toList());

		System.out.println(LongestSubarrayWithDiff1.longestSubarray(array));
	}
}
