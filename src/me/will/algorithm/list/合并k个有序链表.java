package me.will.algorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个有序列表
 */
public class 合并k个有序链表 {
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		for (ListNode head : lists) {
			if (head != null) {
				queue.add(head);
			}
		}
		// 虚拟头结点
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		while (!queue.isEmpty()) {
			// 获取最小节点，接到结果链表中
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.buildList(new int[]{1, 2, 2, 3, 5});
		ListNode l2 = ListNode.buildList(new int[]{1, 1, 3, 6, 7});
		ListNode head = mergeKLists(new ListNode[]{l1, l2});
		ListNode.print(head);
	}
}
