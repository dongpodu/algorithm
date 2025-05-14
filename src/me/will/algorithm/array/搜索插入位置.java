package me.will.algorithm.array;

/**
 * https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-100-liked
 */
public class 搜索插入位置 {

	/**
	 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0035.%E6%90%9C%E7%B4%A2%E6%8F%92%E5%85%A5%E4%BD%8D%E7%BD%AE.md
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0, right = nums.length - 1;
		int middle = 0;
		while (left <= right) {
			//这里要注意
			middle = left + (right - left) / 2;
			int n = nums[middle];
			if (n < target) {
				left = middle + 1; // target 在左区间，所以[left, middle - 1]
			} else if (n > target) {
				right = middle - 1; // target 在右区间，所以[middle + 1, right]
			} else {
				return middle;
			}
		}
		return right + 1;
	}

	public static void main(String[] args) {

	}
}
