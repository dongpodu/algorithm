package me.will.algorithm;

/**
 * 最佳股票买卖时间
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class 买卖股票最佳时机 {

	/**
	 * https://zhuanlan.zhihu.com/p/53262788
	 *
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
}
