package me.will.algorithm.list;

/**
 * 翻转前n链表
 */
public class 翻转前n链表 {

	public static ListNode reverse(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head.next;

		int step = 0;
		while (step < n) {
			cur.next = pre;
			pre = cur;
			cur = next;
			if (next != null) {
				next = next.next;
			}
			step++;
		}
		// 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
		head.next = cur;
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{0, 1, 2, 3, 4});
		System.out.println("-------翻转后-------");
		ListNode newHead = reverse(head, 2);
		ListNode.print(newHead);
	}


}
