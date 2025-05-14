package me.will.algorithm.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
 */
public class 向右移动数组 {

	/**
	 * 和循环左移类似，这里需要将右旋转为左旋，然后按照左旋算法规则实现
	 *
	 * @param s
	 * @param k
	 * @return
	 */
	public static int[] rotate(int[] s, int k) {
		//取模，防止移动的步数大于数组长度
		int rightSteps = k % s.length;
		//转成左移算法
		int leftSteps = s.length - rightSteps - 1;
		reverse(s, 0, leftSteps);
		reverse(s, leftSteps + 1, s.length - 1);
		reverse(s, 0, s.length - 1);
		return s;
	}

	public static void reverse(int[] array, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {

			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] s = new int[]{1, 2, 3, 4, 5, 6, 7};
		rotate(s, 3);
		List<Integer> collect = Arrays.stream(s)
			.boxed()
			.collect(Collectors.toList());
		System.out.println(collect);
	}
}
