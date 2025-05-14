package me.will.algorithm.array;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-100-liked
 */
public class 第k个最大元素 {

	/**
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		//存放k个最大元素，且数据从小往大排列
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int num : nums) {
			if (heap.size() < k) {
				heap.add(num);
			} else if (heap.peek() < num) {
				heap.poll();
				heap.add(num);
			}
		}

		return heap.poll();
	}
}
