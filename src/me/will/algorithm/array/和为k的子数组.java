package me.will.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
 */
public class 和为k的子数组 {

	/**
	 * [x1,x2,x3,x4,.....,xj,....xi,.....]
	 * 规律：假设0-j之间的和为sum[j]，0-i之间的和为sum[i]，则j-i之间的和为sum[i]-sum[j]
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		//key：0-i之间子数组之和，value：出现的次数
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int sum = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// 0-j的和为sum-k，则j-i的和k，从而0-i的和为sum
			if (map.containsKey(sum - k)) { //如果存在，则代表存在子序列和为k
				result = result + map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
