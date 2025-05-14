package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
 */
public class 交换链表中的节点 {

	/**
	 * https://zhuanlan.zhihu.com/p/632093545
	 *
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = head.next;
		head.next = swapPairs(head.next.next);
		newHead.next = head;
		return newHead;
	}
}
