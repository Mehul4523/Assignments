package tree;

public class BalancedTree {

	public boolean isBalanced(TreeNode root) {
			return checkHeight(root) != -1;
		}
		
	private int checkHeight(TreeNode node) {
		if (node == null)
			return 0;
		
		int leftHeight = checkHeight(node.left);
		if (leftHeight == -1)
			return -1;
		
		int rightHeight = checkHeight(node.right);
		if (rightHeight == -1)
			return -1;
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
			}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
		
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		
		BalancedTree tree = new BalancedTree();
		
		boolean result = tree.isBalanced(root);
		
		System.out.println("Is the tree balanced? " + result);
		}
}
