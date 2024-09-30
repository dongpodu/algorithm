package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 */
public class Subsets {

	/**
	 * https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html#%E6%80%9D%E8%B7%AF
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		backTrack(nums, 0, track, result);
		return result;
	}

	public static void backTrack(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> result) {
		result.add(new ArrayList<>(path));
		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			backTrack(nums, i + 1, path, result);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> subsets = subsets(nums);
		System.out.println(subsets);
	}
}
