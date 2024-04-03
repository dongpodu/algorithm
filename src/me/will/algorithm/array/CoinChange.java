package me.will.algorithm.array;

/**
 *
 */
public class CoinChange {

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
	 * 计算并返回可以凑成总金额所需的 最少的硬币个数
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange1(int[] coins, int amount) {
		//1、定义：dp[j]代表凑成金额j的所需最少的硬币个数
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

	public static void main(String[] args) {
		int[] coins = new int[]{1, 2};
		int count = coinChange(coins, 5);
		System.out.println(count);
	}


}
