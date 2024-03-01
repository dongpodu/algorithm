package me.will.algorithm.array;

public class SearchInRotatedSortArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = (left + right) >> 1;
			if (nums[middle] == target) {
				return middle;
			}
			//左半部分递增
			if (nums[left] <= nums[middle]) {
				//target在左半边
				if (nums[left] <= target && target < nums[middle]) {
					right = middle - 1;
				}
				//target在右半边
				else {
					left = middle + 1;
				}
			}
			//右半部分递增
			else {
				//target在右半边
				if (nums[middle] < target && target <= nums[right]) {
					left = middle + 1;
				}
				//target在左半边
				else {
					right = middle - 1;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		int i = search(nums, 0);
		System.out.println(i);
	}
}
