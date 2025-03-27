package me.will.algorithm.list;

public class DoublyListNode {
	public int val;
	public DoublyListNode pre;
	public DoublyListNode next;

	public DoublyListNode(int val) {
		this.val = val;
	}

	public static DoublyListNode buildList1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		DoublyListNode head = new DoublyListNode(nums[0]);
		DoublyListNode cur = head;
		for (int i = 1; i < nums.length; i++) {
			DoublyListNode newNode = new DoublyListNode(nums[i]);
			cur.next = newNode;
			newNode.pre = cur;
			cur = cur.next;
		}
		return head;
	}

	public static void print(DoublyListNode head) {
		DoublyListNode cur = head;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		DoublyListNode list = buildList1(new int[] {0, 1, 2, 3, 4, 5});
		print(list);
	}
}
