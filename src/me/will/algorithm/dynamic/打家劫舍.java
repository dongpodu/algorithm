package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/house-robber/submissions/629784833/?envType=study-plan-v2&envId=top-100-liked
 */
public class 打家劫舍 {
	/**
	 * https://zhuanlan.zhihu.com/p/98405912
	 */
	int rob(int[] nums) {
		int n = nums.length;
		// dp[i] = x 表示：
		// 从第 i 间房子开始抢劫，最多能抢到的钱为 x
		// base case: dp[n] = 0
		int[] dp = new int[n + 2];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
		}
		return dp[0];
	}
}
