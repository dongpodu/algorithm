package me.will.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 每日温度 {

	/**
	 * https://programmercarl.com/0739.%E6%AF%8F%E6%97%A5%E6%B8%A9%E5%BA%A6.html
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int lens = temperatures.length;
		int[] res = new int[lens];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < lens; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				res[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}

		return res;
	}
}
