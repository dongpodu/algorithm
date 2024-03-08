package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					continue;
				}
				subList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(subList);
		}

		return result;
	}
}
