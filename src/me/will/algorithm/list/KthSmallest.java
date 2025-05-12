package me.will.algorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallest {

	/**
	 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/#slug_kth-smallest-element-in-a-sorted-matrix
	 *
	 * @param matrix
	 * @param k
	 * @return
	 */
	public static int kthSmallest(int[][] matrix, int k) {

		//存放数组，数组第一个是二元数组的数，第二个数是行号，第三个数是列号
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

		//先将每行的第一列数存到队列中
		for (int i = 0; i < matrix.length; i++) {
			pq.offer(new int[]{matrix[i][0], i, 0});
		}

		int res = -1;
		while (!pq.isEmpty() && k > 0) {
			int[] arr = pq.poll();
			res = arr[0];
			k--;

			//再添加
			int i = arr[1], j = arr[2] + 1;
			if (j < matrix[i].length) {
				pq.offer(new int[]{matrix[i][j], i, j});
			}
		}
		return res;
	}
}
