package me.will.algorithm.matrix;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-100-liked
 */
public class 搜索二维矩阵 {

	/**
	 * https://blog.csdn.net/weixin_50348837/article/details/139717656
	 *
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int l = 0, r = m * n - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;  //等同于 (l + r)/2，写成 l + (r-l)/2是为了防止溢出
			if (matrix[mid / n][mid % n] >= target) r = mid;
			else l = mid + 1;
		}
		return matrix[r / n][r % n] == target;
	}


}
