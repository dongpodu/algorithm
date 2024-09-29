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
			backtrack(candidates, target - candidates[i], i + 1, path);
			// 回溯，撤销选择
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
		int[] candidates =
			{292023,15722694,8894300,4431841,179264,6626260,2447100,99653,3322500,2537755,732900,2366390,1073700};
		int target = 17106618;
		List<List<Integer>> combinations = solution.combinationSum(candidates, target);

		// 打印结果
		for (List<Integer> combo : combinations) {
			System.out.println(combo);
		}
	}
}
