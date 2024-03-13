package me.will.algorithm.list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" +
			"val=" + val +
			'}';
	}

	public static ListNode buildList(int[] nums) {
		ListNode head = null;
		ListNode pre = null;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(i);
			if (i == 0) {
				head = node;
			}
			if (pre != null) {
				pre.next = node;
			}
			pre = node;
		}
		return head;
	}

	public static void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		ListNode list = buildList(new int[]{0, 1, 2, 3, 4, 5});
		print(list);
	}
}
