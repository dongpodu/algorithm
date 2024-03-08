package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

	public static List<Integer> middleOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		doOrder(root, result);
		return result;
	}

	public static void doOrder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		doOrder(root.left, result);
		doOrder(root.right, result);
		result.add(root.val);
	}

	public static void main(String[] args) {

	}
}
