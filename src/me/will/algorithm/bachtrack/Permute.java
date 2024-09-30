package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class Permute {

	public static List<List<Integer>> permute(int[] nums) {
		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, path, result);
		return result;
	}

	public static void backtrack(int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
		if (path.size() == nums.length) {
			result.add(new ArrayList<>(path));
		}

		for (int i = 0; i < nums.length; i++) {
			if (path.contains(nums[i])) {
				continue;
			}
			//前进
			path.add(nums[i]);
			backtrack(nums, path, result);
			//回退
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> result = permute(nums);
		System.out.println(result);
	}
}
