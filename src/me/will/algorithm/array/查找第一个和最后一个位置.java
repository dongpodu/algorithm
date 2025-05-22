package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked
 */
public class 查找第一个和最后一个位置 {


	/**
	 * https://liweiwei1419.github.io/leetcode-solution-blog/leetcode-problemset/binary-search/0034-find-first-and-last-position-of-element-in-sorted-array.html
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		// 特判，这一步很重要，否则执行到后序方法可能会出现数组下标越界
		// 同时后序两个方法也不用做特殊判断了
		if (len == 0) {
			return new int[]{-1, -1};
		}

		int num1 = findLowerBound(nums, target);
		// 细节：如果左边界都搜索不到，右边界也没有必要看了
		if (num1 == -1) {
			return new int[]{-1, -1};
		}
		int num2 = findUpBound(nums, target);
		return new int[]{num1, num2};
	}


	private int findLowerBound(int[] nums, int target) {
		// 找等于 target 的第 1 个数的索引，小于一定不符合要求
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			// 根据分支逻辑，这里选择左中位数
			// int mid = left + (right - left) / 2;
			int mid = (left + right) >>> 1;
			// 因为找大于等于 target 的第 1 个数，因此小于一定不符合要求
			// 把它写在分支的前面
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		// 因为有可能不存在目标元素，最后一定要单独判断一下
		if (nums[left] != target) {
			return -1;
		}
		return left;
	}

	private int findUpBound(int[] nums, int target) {
		// 找等于 target 的最后 1 个数的索引，大于一定不符合要求
		// 因为有可能不存在，最后一定要单独判断一下
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			// 根据分支逻辑，这里选择右中位数
			// int mid = left + (right - left + 1) / 2;
			int mid = (left + right + 1) >>> 1;
			// 因为找小于等于 target 的最后 1 个数，因此大于一定不符合要求
			// 把它写在分支的前面
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		// 因为有可能不存在目标元素，最后一定要单独判断一下
		if (nums[left] != target) {
			return -1;
		}
		return left;
	}
}
