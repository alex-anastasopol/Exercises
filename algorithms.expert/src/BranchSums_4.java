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
        return calculateTreeBranchSums(0, root, sums);
    }

    private static List<Integer> calculateTreeBranchSums(Integer currentSumIdx, BinaryTree node, List<Integer> sums) {
        int sum = sums.get(currentSumIdx) + node.value;
        sums.set(currentSumIdx, sum);
        if (node.left != null) {
            calculateTreeBranchSums(currentSumIdx + 1, node.left, sums);
        }

        if (node.right != null) {
            calculateTreeBranchSums(currentSumIdx + 1, node.right, sums);
        }
        return sums;
    }

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(10);
        root.right.right = new BinaryTree(11);

        List<Integer> branchSums = branchSums(root);
        System.out.println(branchSums);
    }
}
