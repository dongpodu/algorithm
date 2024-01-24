package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrder {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		traverse(root, true, result);
		return result;
	}

	public static void traverse(TreeNode root, boolean left, List<List<Integer>> result) {
		if (root == null) {
			return;
		}
		List<Integer> list = new ArrayList<>();
		if (left) {
			if (root.left != null) {
				list.add(root.left.val);
			}
			if (root.right != null) {
				list.add(root.right.val);
			}
		} else {

			if (root.right != null) {
				list.add(root.right.val);
			}
			if (root.left != null) {
				list.add(root.left.val);
			}
		}

		if (list.isEmpty()) {
			return;
		}

		result.add(list);

		traverse(root.left, !left, result);
		traverse(root.right, !left, result);
	}
}
