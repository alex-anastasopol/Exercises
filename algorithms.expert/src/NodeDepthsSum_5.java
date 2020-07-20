import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    return sumNodeDepths(root, 0);
  }
	
	public static int sumNodeDepths(BinaryTree node, int depth) {
	depth++;
	return	(node.left != null ? depth + sumNodeDepths(node.left, depth) : 0) 
		+
		(node.right != null ? depth + sumNodeDepths(node.right, depth) : 0);
	}

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
