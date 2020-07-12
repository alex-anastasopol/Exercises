import java.util.ArrayList;
import java.util.List;

public class BranchSums_4 {
	// This is the class of the input root. Do not edit it.

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private static List<Integer> branchSums(BinaryTree root) {
		List<Integer> sums = new ArrayList<>();
		sums.add(0);
		return calculateTreeBranchSums(root, sums, 0);
	}

	private static List<Integer> calculateTreeBranchSums(BinaryTree node, List<Integer> sums, int index) {
		sums.set(index, sums.get(index) + node.value);
		System.out.println(
				"idx: " + index + ", node: " + node.value + " (left: " + (node.left == null ? "null" : node.left.value)
						+ ", right: " + (node.right == null ? "null" : node.right.value) + "): " + ", sums: " + sums);

		int rightBaseSum = sums.get(index);

		if (node.left != null) {
			System.out.println("	will calc left branch");
			calculateTreeBranchSums(node.left, sums, index);
		}

		if (node.right != null) {
			index = sums.size() - 1;
			System.out.println("	will calc right branch; idx: " + index + "; sums.size():" + sums.size());
			if (node.left != null) {
				sums.add(rightBaseSum);
				index++;
			}
			calculateTreeBranchSums(node.right, sums, index);
		}

		return sums;
	}

	public static void main(String[] args) {

		System.out.println("             1");
		System.out.println("           /    \\");
		System.out.println("         2        3");
		System.out.println("        / \\      / \\");
		System.out.println("       4   5     10  11");
		System.out.println("      /   / \\   / \\    \\");
		System.out.println("     3   1   9  5  14   7");

		// l0
		BinaryTree root = new BinaryTree(1);

		// l1
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);

		// l2
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(10);
		root.right.right = new BinaryTree(11);

		// l3
		root.left.left.left = new BinaryTree(3);
		root.left.right.left = new BinaryTree(1);
		root.left.right.right = new BinaryTree(9);
		root.right.left.left = new BinaryTree(5);
		root.right.left.right = new BinaryTree(14);
		root.right.right.left = new BinaryTree(7);

		List<Integer> branchSums = branchSums(root);
		System.out.println("Sums:" + branchSums);
	}
}
