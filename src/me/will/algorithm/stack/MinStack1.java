package me.will.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/submissions/514671225/
 * <p>
 * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/easy/155.min-stack
 */
public class MinStack1 {
	private Stack<Long> store;
	private long min;

	public MinStack1() {
		store = new Stack<>();
	}

	public void push(int val) {
		if (store.isEmpty()) {
			store.push(0L);
			min = val;
		} else {
			//存的是真实值和上一个min的差值，如果存的值小于0，代表真实值比上一个min还小，那当前的min就是真实值
			store.push(val - min);
			if (val < min) {
				min = val;
			}
		}
	}

	public void pop() {
		Long peek = store.peek();
		//小于0，代表栈顶就是最小元素，它出栈时需要把最小值设置为上一个最小值
		//而上一个min=真实值-栈顶元素，真实值就是当前min
		if (peek < 0) {
			min = min - peek;
		}
		store.pop();
	}

	public int top() {
		Long p = store.peek();
		//如果存的值小于0，代表真实值比上一个min还小，那当前的min就是真实值
		if (p < 0) {
			return (int) min;
		}
		//如果存的值>0，代表真实值比上一个min大，那当前的min就是上一个min
		return (int) (p + min);
	}

	public int getMin() {
		return (int) min;
	}
}
