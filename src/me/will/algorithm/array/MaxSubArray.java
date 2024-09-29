package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/maximum-subarray/submissions/508170046/
 */
public class MaxSubArray {
	/**
	 * https://zhuanlan.zhihu.com/p/144385162
	 *
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		//以nums[i]为结尾的「最大子数组和」为dp[i]
		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		int maxSum = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			maxSum = Math.max(maxSum, dp[i]);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-1, 2, 4, 0, -4, 9, -3};
		System.out.println(maxSubArray(nums));
	}
}
