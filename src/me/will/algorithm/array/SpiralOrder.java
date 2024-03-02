package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/
 */
public class SpiralOrder {

	public static List<Integer> spiralOrder(int[][] matrix) {
		int[] ip = new int[]{0, matrix.length - 1};
		int[] jp = new int[]{0, matrix[0].length - 1};
		List<Integer> result = new ArrayList<>();

		int i = 0;
		int j = 0;
		for (int a = 0; a < 4; a++) {

			//横右，i不动，j向右移动，最小i+1
			if (a == 0) {
				for (; j <= jp[1]; j++) {
					result.add(matrix[i][j]);
					ip[0] += 1;
				}
			}

			//竖下，i向下移动，j不动，最大j-1
			if (a == 1) {
				for (; i <= ip[1]; i++) {
					result.add(matrix[i][j]);
					jp[1] -= 1;
				}
			}

			//横左，i不动，j向左移动，最大i-1
			if (a == 2) {
				for (; j >= jp[0]; j--) {
					result.add(matrix[i][j]);
					ip[1] -= 1;
				}
			}

			//竖上，i向上移动，j不动，最小j+1
			if (a == 1) {
				for (; i >= ip[0]; i--) {
					result.add(matrix[i][j]);
					jp[0] += 1;
				}
			}

			if (ip[0] > ip[1] || jp[0] > jp[1]) {
				break;
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
