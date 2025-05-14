package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 二叉树展开为链表 {

	/**
	 * https://blog.csdn.net/vcj1009784814/article/details/126029068
	 *
	 * @param root
	 */
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode last = root.left;
				while (last.right != null) last = last.right;
				last.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}
