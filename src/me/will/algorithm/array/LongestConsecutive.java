package me.will.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestConsecutive {

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}
		int max = 0;
		for (int num : nums) {
			int n = num;
			// 说明x是连续序列的开头元素Ø
			if (!set.contains(n - 1)) {
				while (set.contains(n + 1)) {
					n++;
				}
			}
			max = Math.max(max, n - num + 1);
		}

		return max;
	}
}
