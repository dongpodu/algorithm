package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 分割等和子集 {
	/**
	 * https://programmercarl.com/0416.%E5%88%86%E5%89%B2%E7%AD%89%E5%92%8C%E5%AD%90%E9%9B%86.html
	 */
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		//总和为奇数，不能平分
		if (sum % 2 != 0) return false;
		int target = sum / 2;
		int[] dp = new int[target + 1];
		for (int i = 0; i < n; i++) {
			for (int j = target; j >= nums[i]; j--) {
				//物品 i 的重量是 nums[i]，其价值也是 nums[i]
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}

			//剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
			if (dp[target] == target)
				return true;
		}
		return dp[target] == target;
	}
}
