package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 完全平方数 {

	/**
	 * https://blog.csdn.net/m0_68989328/article/details/137548467
	 *
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		// 创建一个数组 dp，用于存储数值 i 的最小平方数数量
		int[] dp = new int[n + 1];
		// 定义一个变量 max，用于表示正无穷大的值
		int max = Integer.MAX_VALUE;
		// 初始化 dp 数组，将所有元素初始化为正无穷大
		for (int i = 0; i <= n; i++) {
			dp[i] = max;
		}
		// 将 dp 数组的第一个元素设为 0，因为数字 0 本身就是一个平方数
		dp[0] = 0;
		// 从 1 开始遍历到 n
		for (int i = 1; i <= n; i++) {
			// 从 i 的平方开始遍历到 n
			for (int j = i * i; j <= n; j++) {
				// 更新 dp[j] 的值，dp[j] 表示将 j 分解成平方数之和所需要的最小数量
				// 状态转移方程为：dp[j] = min(dp[j], dp[j - i * i] + 1)
				dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
			}
		}
		// 返回 dp 数组中最后一个元素的值，即表示将 n 分解成平方数之和所需的最小数量
		return dp[n];
	}

}
