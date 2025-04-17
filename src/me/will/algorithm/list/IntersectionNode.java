package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class IntersectionNode {

	/**
	 * 可以让 p1 遍历完链表 A 之后开始遍历链表 B，
	 * 让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;
		int step1 = 0;
		while (true) {
			//null==null是true，所以只会连接一次
			if (p1 == p2) {
				break;
			}

			// p1 走一步，如果走到 A 链表末尾，转到 B 链表
			if (p1 == null) {
				p1 = headB;
			} else {
				p1 = p1.next;
			}

			// p2 走一步，如果走到 B 链表末尾，转到 A 链表
			if (p2 == null) {
				p2 = headA;
			} else {
				p2 = p2.next;
			}
		}
		return p1;
	}

	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
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
		//这个测试用例有问题，因为节点里的值虽然一样（比如A链的节点1和B链的节点1），但因为都是新建的节点，所以用==判断并不相等
		ListNode headA = ListNode.buildList1(new int[]{1, 8, 4, 5});
		ListNode headB = ListNode.buildList1(new int[]{5, 6, 1, 8, 4, 5});
		ListNode node = getIntersectionNode(headA, headB);
		System.out.println(node);
	}
}
