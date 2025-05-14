package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 寻找旋转数组最小值 {

	/**
	 * https://zhuanlan.zhihu.com/p/423784388
	 */

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) { //最小值在右边
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}

}
