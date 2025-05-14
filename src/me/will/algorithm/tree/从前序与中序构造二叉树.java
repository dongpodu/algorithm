package me.will.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 从前序与中序构造二叉树 {

	private Map<Integer, Integer> indexMap = new HashMap<>();


	/**
	 * https://www.cnblogs.com/Jojo-L/p/16494943.html
	 *
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		int n = preorder.length;
		//构造中序遍历的节点到其索引的哈希映射，帮助我们快速定位根节点，降低时间复杂度
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		//分治查找算法
		return buildTree(preorder, 0, n - 1, 0);
	}

	/**
	 * @param preorder      前序遍历结果数组
	 * @param preorderLeft  当前树的前序遍历起始索引
	 * @param preorderRight 当前树的前序遍历结束索引
	 * @param inorderLeft   当前树的中序遍历的起始索引
	 * @return
	 */
	private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
		if (preorderLeft > preorderRight) {
			return null;
		}
		//前序遍历中的第一个节点就是当前树的根节点，在中序遍历的map中快速定位当前树的根节点的索引位置
		int inorderRoot = indexMap.get(preorder[preorderLeft]);
		//构造当前根节点
		TreeNode root = new TreeNode(preorder[preorderLeft]);
		//计算左子树中的节点数目
		int sizeLeftSubtree = inorderRoot - inorderLeft;
		//递归的遍历、构造左右子树
		root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
		root.right = buildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
		return root;
	}

}
