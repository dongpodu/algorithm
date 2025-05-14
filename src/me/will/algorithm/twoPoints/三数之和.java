package me.will.algorithm.twoPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class 三数之和 {

	/**
	 * https://www.programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E6%80%9D%E8%B7%AF
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 1; i++) {

			if (nums[i] > 0) {
				return result;
			}

			//因为已经是排序的，所以i只需要和相邻的比较是否相等
			//i固定后，后面的while循环会将所有left、right的组合找到。当i再向前移动一步时，如果和前面的数相等，那在后面的while循环中必然
			//还会找到相同的left和right组合，所以要跳过。left和right去重同理
			if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// 去重逻辑应该放在找到一个三元组之后，对b和c去重
					while (left < right && nums[left] == nums[left + 1]) left++;
					while (left < right && nums[right] == nums[right - 1]) right--;

					// 找到答案时，双指针同时收缩
					left++;
					right--;

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {0, 0, 0, 0};
		List<List<Integer>> list = solution(nums);
		System.out.println(list);
	}
}
