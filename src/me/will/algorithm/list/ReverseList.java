package me.will.algorithm.list;

import java.util.LinkedList;

public class ReverseList {

	public void reverseKGroup(Node head, int k) {
		if (k == 1) {
			return;
		}
		int i = 0;
		Node cur = head;
		Node pre = null;
		Node tmp = null;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
	}

	public static class Node {
		private int val;
		private Node next;
	}
}
