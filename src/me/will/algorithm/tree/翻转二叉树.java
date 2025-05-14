package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/invert-binary-tree/submissions/629702374/?envType=study-plan-v2&envId=top-100-liked
 */
public class 翻转二叉树 {

	/**
	 * https://labuladong.online/algo/data-structure/binary-tree-part1/#%E7%AC%AC%E4%B8%80%E9%A2%98%E3%80%81%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91
	 *
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		// 遍历二叉树，交换每个节点的子节点
		traverse(root);
		return root;
	}

	// 二叉树遍历函数
	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		// *** 前序位置 ***
		// 每一个节点需要做的事就是交换它的左右子节点
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		// 遍历框架，去遍历左右子树的节点
		traverse(root.left);
		traverse(root.right);
	}
}
