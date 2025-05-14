package me.will.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 路径总和3 {
	private Map<Long, Integer> map;
	private int result = 0, target = 0;

	/**
	 * https://zhuanlan.zhihu.com/p/637595125
	 */
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		target = targetSum;
		map = new HashMap();
		map.put(0L, 1);
		dfs(root, root.val);
		return result;
	}

	public void dfs(TreeNode node, long value) {
		result += map.getOrDefault(value - target, 0);
		map.put(value, map.getOrDefault(value, 0) + 1);
		if (node.left != null) dfs(node.left, value + node.left.val);
		if (node.right != null) dfs(node.right, value + node.right.val);
		map.put(value, map.getOrDefault(value, 0) - 1);
	}
}
