package me.will.algorithm.bachtrack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 组合总和 {

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
		组合总和 solution = new 组合总和();
		int[] candidates =
			{182000, 1246000, 150000, 4857799, 721000, 769350, 9773762, 7487782, 8956377, 9831319, 7597604, 9050449, 9088117, 60000, 648000, 6610000, 9780000, 5385000, 8770000, 5840000, 6798200, 9299700, 9497500, 8540600, 2351979, 9749996, 9350000, 9689547, 9800022, 3215000, 1997200, 10744600, 8530200, 546000, 528728, 278728, 3777006, 8939366, 9388305, 9185725, 8703233, 9679971, 8434015, 9066260, 112000, 360000, 718000, 359200, 1616400, 1798600};
		int target = 23049000;
		List<List<Integer>> combinations = solution.combinationSum(candidates, target);

		// 打印结果
		for (List<Integer> combo : combinations) {
			List<BigDecimal> list = combo.stream()
				.map(r -> new BigDecimal(r).divide(BigDecimal.valueOf(100)))
				.collect(Collectors.toList());
			System.out.println(list);
		}
	}
}
