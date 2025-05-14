package me.will.algorithm.matrix;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class 矩阵置零 {
	/**
	 * https://blog.csdn.net/vxzhg/article/details/125120720
	 *
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < col.length; j++) {
			if (col[j]) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
