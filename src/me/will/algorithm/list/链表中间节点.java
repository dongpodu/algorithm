package me.will.algorithm.list;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class 链表中间节点 {
	/**
	 * 我们让两个指针 slow 和 fast 分别指向链表头结点 head。
	 * 每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
	 *
	 * @param head
	 * @return
	 */
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5, 6});
		ListNode node = middleNode(head);
		System.out.println(node);
	}

}
