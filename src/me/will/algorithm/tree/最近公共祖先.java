package me.will.algorithm.tree;

/**
 * 最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class 最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		//在左子树中查找p或q
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//在右子树中查找p或q
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null && right == null) {
			return null;
		} else if (left != null && right == null) {
			return left;
		} else if (left == null && right != null) {
			return right;
		} else {
			return root;
		}
	}
}
