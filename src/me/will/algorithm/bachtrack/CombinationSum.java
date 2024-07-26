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
			{106400, 6400, 66400, 1262490, 130653, 371286, 3507838, 20000, 94800, 29600, 80215, 1525500, 7331039, 1631694, 216269, 5000, 101900, 800, 334000, 26800, 197065, 283938, 1980598, 21236342, 339600, 355000, 24122413, 116800, 6540, 13825379, 8400, 646476, 280800, 1922000, 26992, 2237951, 67913433, 37200, 1047221, 1774009, 1141678, 326800, 52134200, 133680, 10454000, 250000, 1811976, 30000, 727355, 53286, 5228738, 57045, 300000, 562205, 442000, 8000, 8000, 5000, 2932900, 2828392, 18374200, 17500, 31200, 8400, 1200, 1268653, 58785, 6659369, 327542, 66000, 4904146, 1051100, 1034400, 9511500, 516500, 283015, 627000, 2272300, 1836221, 249358, 447600, 1959000, 18000, 57200, 65456, 4248026, 1200, 382787, 1268140, 685460, 223600, 521000, 376800, 20000, 1455400, 100000, 5629341, 2400, 415200, 69000, 193600, 36015, 73985, 113500, 38102600, 1200, 107921, 1370100, 60000, 60000, 42000, 2800, 3200, 8622674, 76400, 2252400, 1200, 6000, 10400, 63721600, 383900, 60000, 1246918, 27600, 655982,
				346529, 12400, 211600, 6400, 710000, 52431600, 497600, 12947100, 12947000, 3561400, 1750000, 2196417, 1960551, 1404450, 37000, 28000, 152000, 5563100, 15000, 1206500, 4710100, 521900, 3083445, 909821, 12000, 12579300, 803000, 2373600, 285900};
		int target = 2367611;
		List<List<Integer>> combinations = solution.combinationSum(candidates, target);

		// 打印结果
		for (List<Integer> combo : combinations) {
			System.out.println(combo);
		}
	}
}
