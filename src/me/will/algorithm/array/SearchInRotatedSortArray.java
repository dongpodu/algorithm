package me.will.algorithm.array;

public class SearchInRotatedSortArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		return search1(nums, target, 0, nums.length - 1);

	}

	public static int search1(int[] nums, int target, int start, int end) {
		int middle = end - start / 2;
		if (nums[start] < nums[middle]) {
			if (nums[start] <= target && target <= nums[middle]) {
				return binarySearch(nums, target, start, middle);
			} else {
				return search1(nums, target, middle, end);
			}
		} else {
			if (nums[middle] <= target && target <= nums[end]) {
				return binarySearch(nums, target, middle, end);
			} else {
				return search1(nums, target, start, middle);
			}
		}
	}

	public static int binarySearch(int[] nums, int target, int start, int end) {
		if (end - start <= 2) {
			for (int i = start; i < end; i++) {
				if (nums[i] == target) {
					return i;
				}
			}
			return -1;
		}

		int middle = end - start / 2 + start;
		if (nums[middle] == target) {
			return middle;
		} else if (nums[middle] < target) {
			return binarySearch(nums, target, middle, end);
		} else {
			return binarySearch(nums, target, start, middle);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		int i = search(nums, 0);
		System.out.println(i);
	}
}
