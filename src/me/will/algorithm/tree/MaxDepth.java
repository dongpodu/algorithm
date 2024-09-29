package me.will.algorithm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxDepth {

	/**
	 * 层次遍历法
	 *
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
		int maxDepth = 1;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		nodeDepthMap.put(root, 1);
		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();
			Integer depth = nodeDepthMap.get(n);
			maxDepth = Math.max(maxDepth, depth);
			if (n.left != null) {
				queue.add(n.left);
				nodeDepthMap.put(n.left, depth + 1);
			}
			if (n.right != null) {
				queue.add(n.right);
				nodeDepthMap.put(n.right, depth + 1);
			}
		}
		return maxDepth;
	}

	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
	}
}
