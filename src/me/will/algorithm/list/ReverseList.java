package me.will.algorithm.list;

public class ReverseList {

	/**
	 * 翻转整个链表，双指针法
	 * https://www.programmercarl.com/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.html#%E6%80%9D%E8%B7%AF
	 *
	 * @param head
	 * @return
	 */
	public static Node reverse(Node head) {
		Node cur = head;
		Node pre = null;
		Node tmp = null;

		while (cur != null) {
			tmp = cur.next;

			cur.next = pre;
			pre = cur;

			cur = tmp;
		}
		return pre;
	}

	/**
	 * 按照k个元素一组翻转链表
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node reverseKGroup(Node head, int k) {
		if (k == 1) {
			return head;
		}
		int loop = size(head) / k;
		Node cur = head;
		Node pre = null;
		Node tmp = null;

		Node newHead = null;
		for (int i = 0; i < loop; i++) {
			for (int j = 0; j < k; j++) {
				tmp = cur.next;

				cur.next = pre;
				pre = cur;

				cur = tmp;
			}

			//保留新头节点
			if (i == 0) {
				newHead = pre;
			}

			if (tmp == null) {
				break;
			}

			pre = tmp;
			cur = tmp.next;

		}
		return newHead;
	}

	public static int size(Node head) {
		int i = 0;
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
			i++;
		}
		return i;
	}

	public static void print(Node head) {
		Node cur = head;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}

	public static class Node {
		private int val;
		private Node next;

		public Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node{" +
				"val=" + val +
				'}';
		}
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		print(head);

		System.out.println("-------翻转后-------");
		Node newHead = reverse(head);
		print(newHead);
	}


}
