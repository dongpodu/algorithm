package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 数组的长度是n，数组内的数字在0-n-1范围内，找出这个数组中任意一对重复数字
 */
public class 寻找重复数 {

	/**
	 * 将arr[i]当做下标，形成一个链表。说明一定有环，环节点就是重复的节点
	 * https://www.cnblogs.com/swx123/p/17271979.html
	 *
	 * @param arr
	 */
	public static int findDuplicate(int[] arr) {
		int slow = 0, fast = 0;
		while (true) {
			slow = arr[slow];
			fast = arr[arr[fast]];
			//因为题目假设一定有重复的，所以就不用考虑无环无法结束的情况
			if (slow == fast) {
				break;
			}
		}
		int newStart = 0;
		while (true) {
			newStart = arr[newStart];
			slow = arr[slow];
			if (newStart == slow) {
				break;
			}
		}
		return newStart;
	}

	public static int findDuplicate1(int[] arr) {
		int d = 0;
		for (int i = 0; i < arr.length; ) {
			if (arr[i] != i) { //循环调换，直到arr[i]==i才往下比较下一个数
				if (arr[i] == arr[arr[i]]) {
					d = arr[i];
					break;
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			} else {
				i++;
			}
		}
		return d;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 1};
		int duplicate = findDuplicate(arr);
		System.out.println(duplicate);
	}
}
