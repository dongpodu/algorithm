package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/
 */
public class SpiralOrder {

	public static List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0;
		int upper = 0;
		int right = n - 1;
		int bottom = m - 1;

		List<Integer> result = new ArrayList<>();
		while (result.size() < m * n) {
			//横右，i不动，j向右移动，最小i+1
			if (upper <= bottom) {
				for (int i = left; i <= right; i++) {
					result.add(matrix[upper][i]);
				}
				upper++;
			}


			//竖下，i向下移动，j不动，最大j-1
			if (left <= right) {
				for (int i = upper; i <= bottom; i++) {
					result.add(matrix[i][right]);
				}
				right--;
			}


			//横左，i不动，j向左移动，最大i-1
			if (upper <= bottom) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
				bottom--;
			}


			//竖上，i向上移动，j不动，最小j+1
			if (left <= right) {
				for (int i = bottom; i >= upper; i--) {
					result.add(matrix[i][left]);
				}
				left++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		List<Integer> list = spiralOrder(matrix);
		System.out.println(list);
	}
}
