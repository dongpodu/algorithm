package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 */
public class TwoSum {
	/**
	 * 暴力解法
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	/**
	 * 高效解法
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		//key为元素，value为下标
		Map<Integer, List<Integer>> map = new HashMap<>();
		//key为target-元素，value为下标
		Map<Integer, List<Integer>> dMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], r -> new ArrayList<>()).add(i);
			dMap.computeIfAbsent(target - nums[i], r -> new ArrayList<>()).add(i);
		}

		for (Integer d : dMap.keySet()) {
			List<Integer> list = dMap.get(d);
			List<Integer> list1 = map.get(d);
			if (list1 != null) {
				Integer i = list.get(0);
				Integer j = list1.stream().filter(r -> !r.equals(i))
					.findAny()
					.orElse(null);
				if (j != null) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}
}
