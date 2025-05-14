package me.will.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 杨辉三角 {
	/**
	 * https://blog.csdn.net/qq_41142785/article/details/116296650
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					list.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
				}
			}
			triangle.add(list);
		}
		return triangle;
	}
}
