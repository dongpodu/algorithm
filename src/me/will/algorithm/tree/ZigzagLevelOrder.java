package me.will.algorithm.tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrder {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		boolean flag = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				subList.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			if (!flag) {
				Collections.reverse(subList);//翻转
			}

			result.add(subList);
			flag = !flag;
		}
		return result;
	}
}
