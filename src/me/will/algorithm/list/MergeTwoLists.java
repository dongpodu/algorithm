package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

	/**
	 * 双指针法：谁大谁就停下，等待下一次比较
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode pre = null;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null || p2 != null) {
			ListNode node = null;
			if (p1 != null && p2 != null) {
				if (p1.val <= p2.val) {
					node = new ListNode(p1.val);

					p1 = p1.next;
				} else {
					node = new ListNode(p2.val);

					p2 = p2.next;
				}
			} else if (p1 != null) {
				node = new ListNode(p1.val);

				p1 = p1.next;
			} else {
				node = new ListNode(p2.val);

				p2 = p2.next;
			}

			if (head == null) {
				head = node;
			}
			if (pre != null) {
				pre.next = node;
			}
			pre = node;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.buildList(new int[]{1, 2, 4});
		ListNode l2 = ListNode.buildList(new int[]{1, 3, 4});

		ListNode node = mergeTwoLists(l1, l2);
		ListNode.print(node);
	}
}
