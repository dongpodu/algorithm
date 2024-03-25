package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/sort-list/
 */
public class SortList {

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

		return MergeTwoLists.mergeTwoLists(node, node1);
	}

	public static void main(String[] args) {
		ListNode list = ListNode.buildList(new int[]{4, 2, 1, 3});
		ListNode newList = sortList(list);
		ListNode.print(newList);
	}
}
