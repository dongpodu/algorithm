package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 二叉树直径 {
	// 记录最大直径的长度
	int maxDiameter = 0;

	/**
	 * https://labuladong.online/algo/essential-technique/binary-tree-summary/#%E5%90%8E%E5%BA%8F%E4%BD%8D%E7%BD%AE%E7%9A%84%E7%89%B9%E6%AE%8A%E4%B9%8B%E5%A4%84
	 *
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		// 对每个节点计算直径，求最大直径
		traverse(root);
		return maxDiameter;
	}

	// 遍历二叉树
	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		// 对每个节点计算直径
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		int myDiameter = leftMax + rightMax;
		// 更新全局最大直径
		maxDiameter = Math.max(maxDiameter, myDiameter);

		traverse(root.left);
		traverse(root.right);
	}

	int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return 1 + Math.max(leftMax, rightMax);
	}
}
