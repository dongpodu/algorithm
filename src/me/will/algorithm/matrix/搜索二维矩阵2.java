package me.will.algorithm.matrix;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 搜索二维矩阵2 {
	/**
	 * https://juejin.cn/post/7238918259754958907
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length - 1, col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target) row--;
			else if (matrix[row][col] < target) col++;
			else return true;
		}
		return false;
	}
}
