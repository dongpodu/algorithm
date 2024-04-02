package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombineSum3 {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> combine = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backTrack(k, 0, n, combine, result);
		return result;
	}


	public static void backTrack(int k, int start, int remain, List<Integer> combine, List<List<Integer>> result) {
		if (combine.size() == k && remain == 0) {
			result.add(new ArrayList<>(combine));
			return;
		}

		if (start > remain) {
			return;
		}

		for (int i = start + 1; i <= 9; i++) {
			if (i > remain) {
				break;
			}
			remain = remain - i;
			combine.add(i);

			backTrack(k, i, remain, combine, result);

			remain = remain + i;
			combine.remove(combine.size() - 1);
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> lists = combinationSum3(3, 7);
		System.out.println(lists);
	}

}
