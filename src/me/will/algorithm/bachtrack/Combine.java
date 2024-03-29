package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/combinations/
 */
public class Combine {


	/**
	 * 从1....n中取取出k个数作为一个组合，计算这样的组合有多少
	 */
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		Stack<Integer> combine = new Stack<>();
		backTracking(n, k, 1, combine, result);
		return result;
	}

	public static void backTracking(int n, int k, int start, Stack<Integer> combine, List<List<Integer>> result) {
		if (combine.size() == k) {
			result.add(new ArrayList<>(combine));
			return;
		}

		for (int i = start; i <= n; i++) {
			combine.add(i);
			backTracking(n, k, i + 1, combine, result);
			combine.pop();
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = combine(5, 2);
		System.out.println(result);
	}
}
