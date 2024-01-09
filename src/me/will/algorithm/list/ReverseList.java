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
		Node forward = null;//前进指针

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
