package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 二叉搜索树第k小节点 {
	int count = 0, result = -1;

	/**
	 * https://zhuanlan.zhihu.com/p/634754453
	 *
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		if (root == null || result != -1) {
			return -1;
		}
		kthSmallest(root.left, k);
		if (++count == k) result = root.val;
		kthSmallest(root.right, k);
		return result;
	}
}
