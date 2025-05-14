package me.will.algorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sort-list/
 */
public class 排序链表 {

	public static ListNode sortList1(ListNode head) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		ListNode p = head;
		while (p != null) {
			queue.add(p);
			p = p.next;
		}
		ListNode dummy = new ListNode(-1000);
		ListNode pre = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			pre.next = node;
			node.next = null;
			pre = node;
		}
		return dummy.next;
	}

	public static ListNode sortList(ListNode head) {
		return sortList(head, null);
	}

	/**
	 * 二分归并，将链表一分为二，分到每个链表最多只有一个元素为止（递归），此时可视为这两个链表是有序的
	 * 然后将两个链表合并
	 *
	 * @param head
	 * @param tail
	 * @return
	 */
	public static ListNode sortList(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}

		if (head.next == tail) {
			head.next = null;
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;
		while (fast != tail) {
			fast = fast.next;
			slow = slow.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}

		ListNode mid = slow;
		ListNode node = sortList(head, mid);
		ListNode node1 = sortList(mid, tail);

		return 合并两个有序链表.mergeTwoLists(node, node1);
	}

	public static void main(String[] args) {
		ListNode list = ListNode.buildList(new int[]{4, 2, 1, 3,5,7,9,8,6});
		ListNode newList = sortList1(list);
		ListNode.print(newList);
	}
}
