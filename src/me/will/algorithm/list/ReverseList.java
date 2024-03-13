package me.will.algorithm.list;

public class ReverseList {

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
		ListNode forward = null;//前进指针

		while (cur != null) {
			//记录前进指针，为下一步循环做准备
			forward = cur.next;

			//指针反转
			cur.next = pre;

			//前进一步
			pre = cur;
			cur = forward;
		}
		return pre;
	}

	public static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{0, 1, 2, 3, 4});
		print(head);
		System.out.println("-------翻转后-------");
		ListNode newHead = reverse(head);
		print(newHead);
	}


}
