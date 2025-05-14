package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked
 */
public class 查找第一个和最后一个位置 {


	/**
	 * 寻找target在数组里的左右边界，有如下三种情况：
	 * <p>
	 * 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
	 * 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
	 * 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
	 * https://programmercarl.com/0034.%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%92%8C%E6%9C%80%E5%90%8E%E4%B8%80%E4%B8%AA%E4%BD%8D%E7%BD%AE.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	int[] searchRange(int[] nums, int target) {
		int leftBorder = getLeftBorder(nums, target);
		int rightBorder = getRightBorder(nums, target);
		// 情况一
		if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
		// 情况三
		if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
		// 情况二
		return new int[]{-1, -1};
	}

	int getRightBorder(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
		while (left <= right) {
			int middle = left + ((right - left) / 2);
			if (nums[middle] > target) {
				right = middle - 1;
			} else { // 寻找右边界，nums[middle] == target的时候更新left
				left = middle + 1;
				rightBorder = left;
			}
		}
		return rightBorder;
	}

	int getLeftBorder(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
				right = middle - 1;
				leftBorder = right;
			} else {
				left = middle + 1;
			}
		}
		return leftBorder;
	}
}
