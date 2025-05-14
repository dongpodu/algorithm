package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class 相交链表 {

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
