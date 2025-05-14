package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 二叉树右视图 {

	/**
	 * https://juejin.cn/post/7133380957737844743
	 */
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> res = new ArrayList<>();
		level(root, 1, res);
		return res;
	}


	void level(TreeNode root, int depth, List<Integer> res) {
		// 如果当前节点的深度还没出现在 res 中（因为一层就一个节点）
		// 那说明当前节点是该层第一个被访问的节点，将当前节点的值加入 res
		if (res.size() < depth) {
			res.add(root.val);
		}
		// 遍历右子树
		if (root.right != null) {
			level(root.right, depth + 1, res);
		}
		// 遍历左子树
		if (root.left != null) {
			level(root.left, depth + 1, res);
		}
	}

}
