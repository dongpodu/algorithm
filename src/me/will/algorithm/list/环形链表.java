package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
 * 检查链表是否有环
 */
public class 环形链表 {

	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
