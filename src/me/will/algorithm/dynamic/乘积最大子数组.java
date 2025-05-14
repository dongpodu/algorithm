package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/?envType=study-plan-v2&envId=top-100-liked
 */
public class 乘积最大子数组 {


	public int max = 1;
	public int min = 1;
	public int res = Integer.MIN_VALUE;

	/**
	 * https://blog.csdn.net/Forlogen/article/details/108940588
	 */
	public int maxProduct(int[] nums) {
		if (nums == null) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				swap();
			}

			max = Math.max(max * nums[i], nums[i]);
			min = Math.min(min * nums[i], nums[i]);
			res = Math.max(res, max);
		}

		return res;
	}

	public void swap() {
		int temp = max;
		max = min;
		min = temp;
	}


}
