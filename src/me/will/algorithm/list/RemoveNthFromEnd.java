package me.will.algorithm.list;

public class RemoveNthFromEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int size = size(head);
		int removeIndex = size - n;
		if (removeIndex < 0) {
			return head;
		}
		int i = 0;
		ListNode current = head;
		ListNode pre = null;
		ListNode newHead = head;
		while (current != null) {
			if (i < removeIndex) {
				pre = current;
				current = current.next;
				i++;
				continue;
			}

			if (current == head) {
				newHead = current.next;
			}
			if (pre != null) {
				pre.next = current.next;
			}
			current.next = null;
			break;
		}
		return newHead;
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
		ListNode head = ListNode.buildList(new int[]{0, 1, 2, 3, 4, 5});

		ListNode.print(head);
		System.out.println("-------删除后-------");
		ListNode newHead = removeNthFromEnd(head, 5);
		ListNode.print(newHead);
	}
}
