package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		doOrder(root, result);
		return result;
	}

	public static void doOrder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		doOrder(root.left, result);
		doOrder(root.right, result);
	}

	public static void main(String[] args) {

	}
}
