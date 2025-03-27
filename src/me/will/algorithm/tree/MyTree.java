package me.will.algorithm.tree;

/**
 * 二叉树（通用实现方式）
 */
public class MyTree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	// 构建出来的二叉树是这样的：
	//     1
	//    / \
	//   2   3
	//  /   / \
	// 4   5   6
	public static MyTree build() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		MyTree tree = new MyTree();
		tree.root = root;
		return tree;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "TreeNode{" +
				"val=" + val +
				'}';
		}
	}
}
