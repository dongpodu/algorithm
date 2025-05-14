package me.will.algorithm.list;

/**
 * 环形链表2
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class 环形链表2 {


	/**
	 * https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
	 *
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;//慢指针，一次一步
		ListNode fast = head;//快指针，一次两步
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { //快慢指针相遇
				break;
			}
		}

		/**
		 * 可以证明慢指针和head指针在环的入口处相遇
		 */
		while (head != slow) {  //同时移动head和慢指针
			head = head.next;
			slow = slow.next;
		}
		return head;                //两指针相遇处即为环的入口
	}
}
