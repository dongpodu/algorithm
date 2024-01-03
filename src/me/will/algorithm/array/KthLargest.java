package me.will.algorithm.array;

import java.util.PriorityQueue;

public class KthLargest {

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
