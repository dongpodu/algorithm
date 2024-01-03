package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E6%80%9D%E8%B7%AF
 */
public class ThreeSumCount {

	public List<List<Integer>> sulotion(List<Integer> nums) {
		List<List<Integer>> result = new ArrayList<>();
		nums.sort(Comparator.comparing(t -> t));
		for (int i = 0; i <= nums.size() - 3; i++) {

			if (nums.get(i) > 0) {
				return result;
			}

			if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {  // 去重a
				continue;
			}

			int left = i + 1;
			int right = nums.size() - 1;
			while (right > left) {
				int sum = nums.get(i) + nums.get(left) + nums.get(right);
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					result.add(Arrays.asList(nums.get(i), nums.get(left), nums.get(right)));

					// 去重逻辑应该放在找到一个三元组之后，对b和c去重
					while (right > left && nums.get(left).equals(nums.get(left + 1))) left++;
					while (right > left && nums.get(right).equals(nums.get(right - 1))) right--;

					right--;
					left++;

				}
			}
		}

		return result;
	}
}
