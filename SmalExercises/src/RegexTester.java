import java.util.*;

class RegexTester {
	private static final int MAX_GOAL_LENGTH = 100000;
	private static final int MAX_INITIAL_LENGTH = 10;

	public static int minimumConcat(String initial, String goal) {
		// Put your code here
		initial = initial.toLowerCase();
		goal = goal.toLowerCase();

		if (!areAllCharsInGoalPresentInInitial(goal, initial) || initial.length() > MAX_INITIAL_LENGTH
				|| goal.length() > MAX_GOAL_LENGTH) {
			return -1;
		}

		int sequencesCount = getSequencesCount(initial, goal);

		return sequencesCount;
	}

	static List<String> getAllPossibleSubstringsOf1CharLess(String testSubstring) {
		List<String> allSubstrings = new ArrayList<String>();
		if (testSubstring.length() <= 0) {
			return allSubstrings;
		}
		
		allSubstrings.add(testSubstring);
		for(int i=0;i<testSubstring.length();i++) {
			allSubstrings.add(testSubstring);
		}

		// TODO
		return allSubstrings;
	}

	private static int getSequencesCount(String initial, String remainingGoal) {
		int sequencesCount = 0;
		String testSubstring = initial;
		List<String> allSubstringsToCheck = new ArrayList<String>();
		allSubstringsToCheck.add(initial);
		while (testSubstring.length() > 0) {
			for (String s : allSubstringsToCheck) {
				if (remainingGoal.contains(s)) {
					remainingGoal = remainingGoal.substring(s.length());
					sequencesCount++;
				}
			}

			allSubstringsToCheck = getAllPossibleSubstringsOf1CharLess(testSubstring);
		}

		return sequencesCount;
	}

	private static boolean areAllCharsInGoalPresentInInitial(String goal, String initial) {
		List<Character> initialCharsList = new ArrayList<Character>();
		for (char c : initial.toCharArray()) {
			initialCharsList.add(c);
		}

		List<Character> goalCharsList = new ArrayList<Character>();
		for (char c : goal.toCharArray()) {
			goalCharsList.add(c);
		}

		for (Character c : goalCharsList) {
			if (!initialCharsList.contains(c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String initial = sc.nextLine();
		String goal = sc.nextLine();

		int res = Rextester.minimumConcat(initial, goal);
		System.out.println(res);

		sc.close();
	}
}