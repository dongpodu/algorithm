package me.will.algorithm.tree;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 验证二叉搜索树 {
	/**
	 * https://houbb.github.io/2020/06/08/algorithm-15-bst-valid
	 *
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	// 测试场景中会针对 int 的最大/小值做边界测试
	private boolean isValidBST(TreeNode root, long lower, long upper) {
		if (root == null) {
			return true;
		}
		int val = root.val;
		//节点的左子树只包含小于当前节点的数。
		if (lower >= val) {
			return false;
		}
		//节点的右子树只包含大于当前节点的数。
		if (upper <= val) {
			return false;
		}
		//所有左子树和右子树自身必须也是二叉搜索树。
		return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
	}


	Long pre = Long.MIN_VALUE;

	public boolean isValidBST1(TreeNode root) {
		if(root == null) {
			return true;
		}
		// 左
		boolean l = isValidBST1(root.left);
		// 中
		int val = root.val;
		if(val <= pre) {
			return false;
		}
		pre = (long) val;
		// 右
		boolean r = isValidBST(root.right);
		return l && r;
	}
}
