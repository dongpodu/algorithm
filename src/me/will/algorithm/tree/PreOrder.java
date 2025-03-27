package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历顺序是固定的，一般都是先左后右，
 * 但因计算逻辑在不同位置，又分为前序（在前面）、中序（在中间）、后序（在后面）遍历。
 */
public class PreOrder {

	public static List<MyTree.TreeNode> preOrder(MyTree tree) {
		List<MyTree.TreeNode> result = new ArrayList<>();
		doOrder(tree.getRoot(), result);
		return result;
	}

	public static void doOrder(MyTree.TreeNode root, List<MyTree.TreeNode> result) {
		if (root == null) {
			return;
		}
		System.out.println("enter:" + root.val);
		// 计算逻辑放在前面，所以是前序遍历
		result.add(root);
		doOrder(root.left, result);
		// result.add(root); 如果是放在中间，则是中序遍历
		doOrder(root.right, result);
		// result.add(root); 如果是放在后面，则是后续遍历
	}

	public static void main(String[] args) {
		MyTree myTree = MyTree.build();
		List<MyTree.TreeNode> result = preOrder(myTree);
		System.out.println(result);
	}
}
