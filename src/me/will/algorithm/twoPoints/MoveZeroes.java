package me.will.algorithm.twoPoints;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		//key：原始位置，value：新位置
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			}
			map.put(i + 1, i - count + 1);
		}
		System.out.println(map);

		//移动
		for (int i = 1; i < nums.length; i++) {
			int index = map.get(i);
			//位置没变动，跳过
			if (index == i) {
				continue;
			}
			//位置变动，原来的位置需要置为0
			nums[index] = nums[i];
			nums[i] = 0;
		}
	}

	public static void moveZeroes1(int[] nums) {
		//左指针代表移动后的最末尾索引
		int left = 0;
		//右指针代表需要移动的索引
		int right = 0;
		while (right < nums.length) {
			//如果不为0，需要交换位置
			if (nums[right] != 0) {
				swap(nums, left, right);
				left++;
			}
			right++;
		}
	}

	public static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};
		moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
