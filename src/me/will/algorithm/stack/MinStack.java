package me.will.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/submissions/514671225/
 *
 * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/easy/155.min-stack
 */
public class MinStack {
	private Stack<Integer> store;
	private Stack<Integer> minStack;

	public MinStack() {
		store = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		store.add(val);
		if (minStack.isEmpty() || minStack.peek() > val) {
			minStack.push(val);
		}
	}

	public void pop() {
		int d = store.pop();
		if (d == minStack.peek()) {
			minStack.pop();
		}

	}

	public int top() {
		return store.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
