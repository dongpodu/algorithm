package me.will.algorithm.list;

/**
 * 删除倒数第n节点
 */
public class RemoveNthFromEnd {

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
		ListNode x = FindNthFromEnd.findFromEnd(dummy, n + 1);
		System.out.println("第n+1节点" + x);
		if (x == null) {
			return null;
		}
		x.next = x.next.next;
		return dummy.next;
	}

	public static ListNode removeNthFromEnd1(ListNode head, int n) {
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

	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int index = size(head) - n + 1;
		if (index < 0) {
			return head;
		}
		int step = 1;
		ListNode newHead = head;
		ListNode curr = head;
		ListNode pre = null;
		while (curr != null) {
			if (step == index) {
				ListNode next = curr.next;
				if (pre != null) {
					pre.next = next;
				} else {
					newHead = next;
				}
				break;
			}
			pre = curr;
			curr = curr.next;
			step++;
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
