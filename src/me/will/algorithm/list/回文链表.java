package me.will.algorithm.list;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/submissions/568780295/?envType=study-plan-v2&envId=top-100-liked
 */
public class 回文链表 {

	public boolean isPalindrome(ListNode head) {
		int size = size(head);
		if (size == 0) {
			return false;
		}
		if (size == 1) {
			return true;
		}
		ListNode curr = head;
		int half = size / 2;
		boolean f = size % 2 == 1;
		int step = 1;
		Stack<Integer> stack = new Stack<>();
		while (curr != null) {
			if (step <= half) {
				stack.push(curr.val);
			} else {
				if (f && step == half + 1) {

				} else {
					if (!stack.pop().equals(curr.val)) {
						return false;
					}
				}
			}
			curr = curr.next;
			step++;
		}

		return true;
	}

	public int size(ListNode head) {
		if (head == null) {
			return 0;
		}
		int size = 0;
		ListNode curr = head;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		return size;
	}
}
