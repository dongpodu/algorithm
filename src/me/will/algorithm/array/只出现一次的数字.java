package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked
 */
public class 只出现一次的数字 {
	/**
	 * https://www.cnblogs.com/gzshan/p/12535178.html
	 */
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}
}
