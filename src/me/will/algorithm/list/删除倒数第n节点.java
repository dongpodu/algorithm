package me.will.algorithm.list;

/**
 * 删除倒数第n节点
 */
public class 删除倒数第n节点 {

	/**
	 * 先找到倒数第n+1节点，然后删除
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		//找到倒数第n+1节点
		ListNode x = 查找倒数第n节点.findFromEnd(dummy, n + 1);
		System.out.println("第n+1节点" + x);
		if (x == null) {
			return null;
		}
		x.next = x.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{0, 1, 2, 3, 4, 5});

		ListNode.print(head);
		System.out.println("-------删除后-------");
		ListNode newHead = removeNthFromEnd(head, 5);
		ListNode.print(newHead);
	}
}
