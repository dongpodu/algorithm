package me.will.algorithm.matrix;

/**
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 旋转图像 {


	/**
	 * https://blog.csdn.net/afei__/article/details/84242702
	 *
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len / 2; i++) {
			int start = i; // 当前环的起始下标（横纵均相等）
			int end = len - i - 1; // 当前环的终点下标（横纵均相等）
			for (int j = 0; j < end - start; j++) {
				int temp = matrix[start][start + j];
				matrix[start][start + j] = matrix[end - j][start];
				matrix[end - j][start] = matrix[end][end - j];
				matrix[end][end - j] = matrix[start + j][end];
				matrix[start + j][end] = temp;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix_3x3 = {{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}};
		rotate(matrix_3x3);
		printMatrix(matrix_3x3);
		System.out.println("*****************************");
		int[][] matrix_4x4 = {{5, 1, 9, 11},
			{2, 4, 8, 10},
			{13, 3, 6, 7},
			{15, 14, 12, 16}};
		rotate(matrix_4x4);
		printMatrix(matrix_4x4);
	}
}
