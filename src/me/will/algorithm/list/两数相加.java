package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/
 */
public class 两数相加 {

	/**
	 * 双指针法
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode pre = null;
		//进位数
		int carry = 0;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null || p2 != null || carry > 0) {
			int v1 = p1 == null ? 0 : p1.val;
			int v2 = p2 == null ? 0 : p2.val;
			int sum = v1 + v2 + carry;

			carry = sum / 10;
			int newV = sum % 10;

			ListNode node = new ListNode(newV);
			if (head == null) {
				head = node;
			}
			if (pre != null) {
				pre.next = node;
			}
			pre = node;
			if (p1 != null) {
				p1 = p1.next;
			}
			if (p2 != null) {
				p2 = p2.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.buildList(new int[]{2, 4, 3});
		ListNode.print(l1);
		ListNode l2 = ListNode.buildList(new int[]{5, 6, 4});
		ListNode.print(l2);
		ListNode newL = addTwoNumbers(l1, l2);
		ListNode.print(newL);
	}

}
