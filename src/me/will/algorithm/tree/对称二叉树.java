package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class 对称二叉树 {

	/**
	 * https://www.cnblogs.com/pingguo-softwaretesting/p/15610576.html
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}

	// 辅助函数
	public boolean check(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		return leftNode.val == rightNode.val
			&& check(leftNode.left, rightNode.right)
			&& check(leftNode.right, rightNode.left);
	}


}
