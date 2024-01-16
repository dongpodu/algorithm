package me.will.algorithm.list;

public class ReverseKGroupList {

	/**
	 * 按照k个元素一组翻转链表
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		int loop = size(head) / k;

		ListNode start = head;//每一轮循环的开始节点
		ListNode newHead = null;//翻转后新的起始节点
		for (int i = 0; i < loop; i++) {
			ListNode cur = start;
			ListNode pre = null;
			ListNode forward = null;
			for (int j = 0; j < k; j++) {
				forward = cur.next;

				cur.next = pre;
				pre = cur;

				cur = forward;

				if (j == k - 1) {
					start = cur;
				}
			}

			if (i == 0) {
				newHead = pre;
			}

			if (forward == null) {
				break;
			}

		}
		return newHead;
	}

	public static int size(ListNode head) {
		int i = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			i++;
		}
		return i;
	}

}
