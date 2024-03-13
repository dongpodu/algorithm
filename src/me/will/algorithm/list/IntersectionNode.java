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
		ListNode headA = ListNode.buildList(new int[]{0, 1, 2, 3, 4});
		ListNode headB = ListNode.buildList(new int[]{10, 3, 5});
		ListNode node = getIntersectionNode(headA, headB);
		System.out.println(node);
	}
}
