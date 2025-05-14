package me.will.algorithm.list;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class k个一组翻转链表 {

	/**
	 * 按照k个元素一组翻转链表
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		// 一开始设置一个虚拟节点，它的值为 -1，它的值可以设置为任何的数，因为我们根本不需要使用它的值
		ListNode dummy = new ListNode(-1);
		// 虚拟头节点的下一节点指向 head 节点
		// 如果原链表是  1 -->  2 -->  3
		// 那么加上虚拟头节点就是  -1 -->  1 -->  2 -->  3
		dummy.next = head;
		// 设置一个指针，指向此时的虚拟节点，pre 表示每次要翻转的链表的头结点的【上一个节点】
		// pre: -1 -->  1 -->  2 -->  3
		ListNode pre = dummy;
		// 设置一个指针，指向此时的虚拟节点，end 表示每次要翻转的链表的尾节点
		// end: -1 -->  1 -->  2 -->  3
		ListNode end = dummy;

		// 通过 while 循环，不断的找到翻转链表的尾部
		while (end.next != null) {
			// 通过 for 循环，找到【每一组翻转链表的尾部】
			// 由于原链表按照 k 个一组进行划分会可能出现有一组的长度不足 k 个
			// 比如原链表 1 -->  2 -->  3 -->  4 -->  5
			// k = 2，划分了三组 1 -->  2， 3 -->  4， 5
			// 所以得确保 end 不为空才去找它的 next 指针，否则 null.next 会报错
			for (int i = 0; i < k && end != null; i++) {
				// end 不断的向后移动，移动 k 次到达【每一组翻转链表的尾部】
				end = end.next;
			}
			// 如果发现 end == null，说明此时翻转的链表的节点数小于 k ，保存原有顺序就行
			if (end == null) {
				// 直接跳出循环，只执行下面的翻转操作
				break;
			}

			// next 表示【待翻转链表区域】里面的第一个节点
			ListNode next = end.next;
			// 【翻转链表区域】的最尾部节点先断开
			end.next = null;
			// start 表示【翻转链表区域】里面的第一个节点
			ListNode start = pre.next;
			// 【翻转链表区域】的最头部节点和前面断开
			pre.next = null;
			// 这个时候，【翻转链表区域】的头节点是 start，尾节点是 end
			// 开始执行【反转链表】操作
			// 原先是 start --> ...--> end
			// 现在变成了 end --> ...--> start

			// 要翻转的链表的头结点的【上一个节点】的 next 指针指向这次翻转的结果
			pre.next = reverse(start);

			// 接下来的操作是在为【待翻转链表区域】的反转做准备

			// 原先是 start --> ...--> end
			// 现在变成了 end --> ...--> start
			// 【翻转链表区域】里面的尾节点的 next 指针指向【待翻转链表区域】里面的第一个节点
			start.next = next;

			// 原先是 start --> ...--> end
			// 现在变成了 end --> ...--> start
			// pre 表示每次要翻转的链表的头结点的【上一个节点】
			pre = start;

			// 将 end 重置为【待翻转链表区域】的头结点的上一个节点。
			end = start;
		}

		return dummy.next;
	}

	/**
	 * 递归方法
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		//返指向
		head.next.next = head;
		//断开指向
		head.next = null;
		return newHead;
	}


}
