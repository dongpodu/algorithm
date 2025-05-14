package me.will.algorithm;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class 滑动窗口最大值 {

	/**
	 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.md
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		MyQueue q = new MyQueue();
		for (int i = 0; i < nums.length + 1; i++) {
			if (i < k) {
				q.add(nums[i]);
			} else if (i < nums.length) {
				result[i - k] = q.peek();
				q.poll(nums[i - k]);
				q.add(nums[i]);
			} else {
				result[i - k] = q.peek();
			}
		}
		return result;
	}

	/**
	 * 单调递减队列
	 */
	public static class MyQueue {
		LinkedList<Integer> q = new LinkedList<>();

		//弹出队头元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
		//同时判断队列当前是否为空
		void poll(int v) {
			if (!q.isEmpty() && q.peek() == v) {
				q.poll();
			}
		}

		//添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
		//保证队列元素单调递减
		//比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
		void add(int v) {
			while (!q.isEmpty() && q.getLast() < v) {
				q.removeLast();
			}
			q.add(v);
		}

		//队头元素就是队列的最大值
		int peek() {
			return q.peek();
		}
	}
}
