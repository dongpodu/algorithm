package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 零钱兑换 {

	/**
	 * 计算凑成amount的组合数
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		//1、定义：dp[j]代表凑成金额j的组合数
		int[] dp = new int[amount + 1];

		//2、递推公式：dp[j]等于所有dp[j-coins[i]]之和，所以dp[j] = dp[j] + dp[j - coins[i]];

		//3、初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
		dp[0] = 1;

		//4、遍历
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				if (j >= coins[i]) {
					dp[j] = dp[j] + dp[j - coins[i]];
				}
			}
		}


		//5、打印
		for (int d : dp) {
			System.out.println(d);
		}

		return dp[amount];
	}

	/**
	 * https://leetcode.cn/problems/coin-change/description/
	 * <p>
	 * https://programmercarl.com/0322.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2.html#%E6%80%9D%E8%B7%AF
	 * 计算并返回可以凑成总金额所需的最少的硬币个数
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange1(int[] coins, int amount) {
		//1、定义：dp[j]代表凑成金额j的所需最少的硬币个数
		int[] dp = new int[amount + 1];

		//2、递推公式：j-coins[i]的最少硬币个数是dp[j-coins[i]]，再加上1个coins[i]，就等于dp[j]
		//所以dp[j]就是要取所有dp[j-coins[i]]+1中最小的

		//3、初始化dp数组（根据题目要求）
		dp[0] = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i == 0 ? 0 : Integer.MAX_VALUE;
		}

		//4、遍历
		for (int i = 0; i < coins.length; i++) { //先遍历物品（硬币）
			for (int j = 0; j <= amount; j++) { //再遍历背包(总金额)
				if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}

		//找不到就返回-1
		if (dp[amount] == Integer.MAX_VALUE) return -1;

		//5、打印
		for (int d : dp) {
			System.out.println(d);
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = new int[]{1, 2};
		int count = coinChange1(coins, 5);
		System.out.println(count);
	}


}
