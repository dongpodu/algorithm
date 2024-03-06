package me.will.algorithm.array;

import java.util.List;

/**
 * https://leetcode.cn/problems/next-permutation/
 */
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		int index = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			//跟前一个数比较，如果大于前一个数，则与前一个数互换位置
			if (nums[i] > nums[i - 1]) {
				switchPos(i, i - 1, nums);
				index = i;
				break;
			}
		}

		if (index > 0) {
			for (int i = index; i < nums.length - 1; i++) {
				//跟后一个数比较，如果大于后一个数，则与后一个数互换位置
				if (nums[i] > nums[i + 1]) {
					switchPos(i, i + 1, nums);
					break;
				}
			}
		} else {
			for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
				switchPos(left, right, nums);
			}
		}
	}

	public static void switchPos(int i, int j, int[] nums) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 1};
		nextPermutation(nums);
		System.out.println(List.of(nums));
	}
}
