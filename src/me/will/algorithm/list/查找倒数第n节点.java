package me.will.algorithm.list;

/**
 * 查找单列表倒数第n节点
 */
public class 查找倒数第n节点 {

	public static ListNode findFromEnd(ListNode head, int n) {
		ListNode p1 = head;

		//让p1先走n步
		for (int i = 0; i < n; i++) {
			if (p1 != null) {
				p1 = p1.next;
			}
		}

		//链表长度不够n，返回null
		if (p1 == null) {
			return null;
		}

		//再让p1，p2同时走，当p1走完链表时，p2指向的就是倒数第n节点
		ListNode p2 = head;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5, 6});
		ListNode nNode = findFromEnd(head, 2);
		System.out.println(nNode);
	}
}
