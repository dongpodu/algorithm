package me.will.algorithm.list;

/**
 * 删除重复的节点
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class 删除重复节点 {
	public static ListNode deleteDuplicates(ListNode head) {
		//重复的链表
		ListNode dummy1 = new ListNode(101);
		//不重复的链表
		ListNode dummy2 = new ListNode(101);
		// p1, p2 指针负责生成结果链表
		ListNode p1 = dummy1, p2 = dummy2;
		// p 负责遍历原链表
		ListNode p = head;
		ListNode curDuplicate = null;
		while (p != null) {
			ListNode newNode = new ListNode(p.val);
			if ((p.next != null && p.val == p.next.val) || (curDuplicate != null && p.val == curDuplicate.val)) {
				p1.next = newNode;
				p1 = p1.next;

				curDuplicate = p;
			} else {
				p2.next = newNode;
				p2 = p2.next;
			}
			//由于节点是新创建的，所以不需要断开原来的next指针
			p = p.next;
		}
		return dummy2.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{1, 2, 2, 3, 3, 4, 5});
		ListNode newHead = deleteDuplicates(head);
		ListNode.print(newHead);
	}
}
