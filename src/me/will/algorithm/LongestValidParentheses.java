package me.will.algorithm;

import java.util.Stack;

/**
 * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/hard/32.longest-valid-parentheses
 */
public class LongestValidParentheses {

	/**
	 * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/hard/32.longest-valid-parentheses
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		//栈存的是下标
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int longest = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				//栈为空，需要存新的开始位置
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					longest = Math.max(longest, i - stack.elementAt(stack.size() - 1));
				}
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParentheses(s));
	}

}
