package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/maximum-subarray/submissions/508170046/
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组是数组中的一个连续部分。
 */
public class 最大子数组和 {
	/**
	 * 动态规划算法
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

	/**
	 * 贪心算法
	 * https://www.cxyxiaowu.com/11963.html
	 *
	 * @param array
	 * @return
	 */
	public static int maxSubArray1(int[] array) {
		int result = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			// 如果部分和小于零，直接舍弃，从零开始重新累加
			if (sum < 0) {
				sum = 0;
			}
			sum += num; // 加上当前元素
			result = Math.max(result, sum);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1};
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArray1(nums));
	}
}
