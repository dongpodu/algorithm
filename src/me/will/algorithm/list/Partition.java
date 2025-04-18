package me.will.algorithm.list;

import java.util.List;

/**
 * 分割链表
 * https://leetcode.cn/problems/partition-list/
 */
public class Partition {

	public static ListNode partition(ListNode head, int x) {
		//小于x的链表
		ListNode dummy1 = new ListNode(-1);
		//大于等于x的链表
		ListNode dummy2 = new ListNode(-1);
		// p1, p2 指针负责生成结果链表
		ListNode p1 = dummy1, p2 = dummy2;
		// p 负责遍历原链表，类似合并两个有序链表的逻辑
		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				p1.next = p;
				p1 = p1.next;
			} else {
				p2.next = p;
				p2 = p2.next;
			}

			// 断开原链表中的每个节点的 next 指针
			ListNode next = p.next;
			p.next = null;
			p = next;
		}
		p1.next = dummy2.next;
		return dummy1.next;
	}

	public static ListNode partition1(ListNode head, int x) {
		//小于x的链表
		ListNode dummy1 = new ListNode(-1);
		//大于等于x的链表
		ListNode dummy2 = new ListNode(-1);
		// p1, p2 指针负责生成结果链表
		ListNode p1 = dummy1, p2 = dummy2;
		// p 负责遍历原链表，类似合并两个有序链表的逻辑
		ListNode p = head;
		while (p != null) {
			ListNode newNode = new ListNode(p.val);
			if (p.val < x) {
				p1.next = newNode;
				p1 = p1.next;
			} else {
				p2.next = newNode;
				p2 = p2.next;
			}
			//由于节点是新创建的，所以不需要断开原来的next指针
			p = p.next;
		}
		p1.next = dummy2.next;
		return dummy1.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.buildList(new int[]{1, 4, 3, 2, 5, 2});
		ListNode newHead = partition1(head, 3);
		ListNode.print(newHead);
	}
}
