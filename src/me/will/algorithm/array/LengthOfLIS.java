package me.will.algorithm.array;

/**
 * 最长递增子序列长度
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
public class LengthOfLIS {

	/**
	 * https://programmercarl.com/0300.%E6%9C%80%E9%95%BF%E4%B8%8A%E5%8D%87%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
	 * <p>
	 * https://writings.sh/post/algorithm-longest-increasing-subsequence
	 *
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		//dp[i]代表以i下标为结尾的子序列最长长度
		int[] dp = new int[nums.length];
		//初始化数组
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}

		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			System.out.println(String.format("i=%s, 长度为=%s", i, dp[i]));
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 0, 3, 2};
		int length = lengthOfLIS(nums);
		System.out.println(length);
	}
}
