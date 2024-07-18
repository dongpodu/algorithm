package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	// 用于存储所有找到的组合
	private List<List<Integer>> result = new ArrayList<>();

	// 主函数，调用回溯方法
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>(); // 用于存储当前路径
		backtrack(candidates, target, 0, path);
		return result;
	}

	// 回溯方法
	private void backtrack(int[] candidates, int target, int start, List<Integer> path) {
		// 如果当前路径的和等于目标值，则添加到结果中
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}

		// 如果当前路径的和已经大于目标值，或者已经遍历完所有元素，则回溯
		if (target < 0 || start == candidates.length) {
			return;
		}

		// 从当前位置开始遍历数组，避免重复组合
		for (int i = start; i < candidates.length; i++) {
			// 选择当前元素
			path.add(candidates[i]);
			// 递归调用，注意start参数仍然为i，允许使用相同的数字多次
			// 如果想要每个数字只能用一次，则将start参数改为i + 1
			backtrack(candidates, target - candidates[i], i, path);
			// 回溯，撤销选择
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
		int[] candidates = {147252, 59773841, 273468, 4943906, 63794082, 295000, 107000, 361874, 2072860, 6503000, 3249600, 4242000, 895800, 486514, 43681, 203596, 245790, 13463131, 8460046, 53774110, 262086, 405000, 107000, 4506966, 23004376, 333933, 81930, 327720, 45475, 5277887, 4068430, 331634, 139296, 442500};
		int target = 82291121;
		List<List<Integer>> combinations = solution.combinationSum(candidates, target);

		// 打印结果
		for (List<Integer> combo : combinations) {
			System.out.println(combo);
		}
	}
}
