package me.will.algorithm.list;

public class IntersectionNode {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = size(headA);
		int sizeB = size(headB);
		if (sizeA == 0 || sizeB == 0) {
			return null;
		}

		ListNode currentA = headA;
		ListNode currentB = headB;

		if (sizeA >= sizeB) {
			int diff = sizeA - sizeB;
			int step = 1;
			while (currentA != null && step <= diff) {
				currentA = currentA.next;
				step++;
			}
		} else {
			int diff = sizeB - sizeA;
			int step = 1;
			while (currentB != null && step <= diff) {
				currentB = currentB.next;
				step++;
			}
		}

		ListNode result = null;
		while (currentA != null && currentB != null) {
			if (currentA == currentB) {
				result = currentA;
				break;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return result;

	}

	public static int size(ListNode head) {
		int size = 0;
		ListNode current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		headA.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode headB = new ListNode(10);
		ListNode n11 = new ListNode(3);
		ListNode n22 = new ListNode(5);
		headB.next = n11;
		n11.next = n22;
//		n22.next = n2;

		ListNode node = getIntersectionNode(headA, headB);
		System.out.println(node);
	}
}
