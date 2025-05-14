package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
 */
public class 除自身以外数组的乘积 {


	/**
	 * https://www.cnblogs.com/GarrettWale/p/15709820.html
	 *
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] pres = new int[n];
		pres[0] = 1;
		for (int i = 1; i < n; i++) {
			pres[i] = pres[i - 1] * nums[i - 1];
		}

		int[] posts = new int[n];
		posts[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			posts[i] = posts[i + 1] * nums[i + 1];
		}
		int[] result = new int[n];
		for (int i = 0; i < nums.length; i++) {
			result[i] = pres[i] * posts[i];
		}
		return result;
	}
}
