import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FindClosestValueInBst_3 {
    private static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value;
        int diff = Math.abs(target - closest);
        if (diff == 0) {
            return closest;
        }

        if (tree.left != null) {
            int closestLeft = findClosestValueInBst(tree.left, target);
            if (Math.abs(target - closestLeft) < closest) {
                closest = closestLeft;
            }
        }

        if (tree.right != null) {
            int closestRight = findClosestValueInBst(tree.right, target);
            if (Math.abs(target - closestRight) < closest) {
                closest = closestRight;
            }
        }

        return closest;
    }

    static class BST {
         int value;
         BST left;
         BST right;

         BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        Logger logger = LoggerFactory.getLogger("findClosestValueInBst");
        int expected = 13;
        int actual = findClosestValueInBst(root, 12);
        System.out.println("Expected: " + expected + ", actual: " + actual);
    }
}

