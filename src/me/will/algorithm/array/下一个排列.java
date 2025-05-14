package me.will.algorithm.array;

import java.util.List;

/**
 * https://leetcode.cn/problems/next-permutation/
 */
public class 下一个排列 {

	/**
	 * https://biaodigit.github.io/LeetCode/0031/#%E9%A2%98%E7%9B%AE%EF%BC%9A%E4%B8%8B%E4%B8%80%E4%B8%AA%E6%8E%92%E5%88%97
	 *
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		//分界点索引,分界点右边是一个倒序递增序列
		int index = nums.length - 1;
		while (index > 0 && nums[index] <= nums[index - 1]) {
			index--;
		}

		//从分界点右边递增序列中找到比分界点前一位大的数，然后互换位置
		if (index > 0) {
			int left = index - 1;
			int right = nums.length - 1;
			while (right >= 0 && nums[left] >= nums[right]) {
				right--;
			}
			switchPos(left, right, nums);
		}

		//再将右边序列调整成最小序列
		int left = index;
		int right = nums.length - 1;
		while (left < right) {
			switchPos(left, right, nums);
			left++;
			right--;
		}
	}

	public static void switchPos(int i, int j, int[] nums) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 5, 1};
		nextPermutation(nums);
		System.out.println(List.of(nums));
	}
}
