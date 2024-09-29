package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

	public static List<Integer> inOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		doOrder(root, result);
		return result;
	}

	public static void doOrder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		doOrder(root.left, result);
		result.add(root.val);
		doOrder(root.right, result);
	}

	public static List<Integer> inOrder1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
