package me.will.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/submissions/569173817/?envType=study-plan-v2&envId=top-100-liked
 */
public class 有效的括号 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (!stack.isEmpty()) {
				char p = stack.pop();
				if ((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']')) {
					continue;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
