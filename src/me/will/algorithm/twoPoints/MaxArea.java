package me.will.algorithm.twoPoints;

/**
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxArea {
	/**
	 * 找到方法如果使得面积增大：左右指针先指向两边，不管移动那边指针，则宽肯定是减少的。
	 * 1、如果向内移动那个高的指针，那有效高（最矮的）要么不变，要么减少，从而使得面积一定会减小。
	 * 2、如果向内移动那个矮的指针，那有效高（最矮的）要么不变，要么增大，从而使得面积可能会增大。
	 * 所以每次按照2来移动指针
	 *
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right) {
			int h = Math.min(height[left], height[right]);
			maxArea = Math.max(h * (right - left), maxArea);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
