package me.will.algorithm.list;

/**
 * 翻转链表
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 反转链表 {

	/**
	 * 翻转整个链表，双指针法
	 * https://www.programmercarl.com/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.html#%E6%80%9D%E8%B7%AF
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = head.next;

		while (cur != null) {
			//指针反转
			cur.next = pre;
			pre = cur;
			cur = next;
			if (next != null) {
				next = next.next;
			}
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{0, 1, 2, 3, 4});
		System.out.println("-------翻转后-------");
		ListNode newHead = reverse(head);
		ListNode.print(newHead);
	}


}
