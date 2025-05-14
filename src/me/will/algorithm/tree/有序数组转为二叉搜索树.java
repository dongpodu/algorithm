package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 有序数组转为二叉搜索树 {

	/**
	 * https://blog.csdn.net/qq_46311811/article/details/122908658
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return helpBuild(nums, 0, nums.length);
	}

	// 这里的的范围是左闭右开的，特别需要搞明白这个
	private TreeNode helpBuild(int[] nums, int left, int right) {
		if (left == right) {
			return null;
		}
		if (right - left == 1) {
			return new TreeNode(nums[left]);
		}
		// 找到中间的根节点
		int idx = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[idx]);
		// 构造左子树
		node.left = helpBuild(nums, left, idx);
		// 构造右子树
		node.right = helpBuild(nums, idx + 1, right);
		return node;
	}
}
