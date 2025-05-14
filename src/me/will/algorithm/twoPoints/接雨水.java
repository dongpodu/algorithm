package me.will.algorithm.twoPoints;

import java.util.Stack;

/**
 * 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class 接雨水 {

	/**
	 * https://zhuanlan.zhihu.com/p/79811305
	 *
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) {
		//存的是下标
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			//如果栈不空并且当前指向的高度大于栈顶高度就一直循环
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				//取出要出栈的元素
				int h = height[stack.peek()];
				//出栈
				stack.pop();
				// 栈空就出去
				if (stack.isEmpty()) {
					break;
				}
				//两堵墙之前的距离。
				int distance = i - stack.peek() - 1;
				int min = Math.min(height[stack.peek()], height[i]);
				result = result + (min - h) * distance;
			}
			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int result = trap(height);
		System.out.println(result);
	}
}
