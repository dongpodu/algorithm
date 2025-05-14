package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class 合并数组 {

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return null;
		}
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (i == intervals.length - 1) {
				result.add(curr);
				break;
			}
			int[] next = intervals[i + 1];
			if (curr[1] < next[0]) {
				result.add(curr);
			} else if (curr[1] <= next[1]) {
				next[0] = curr[0];
			} else {
				next[0] = curr[0];
				next[1] = curr[1];
			}
		}
		int[][] array = new int[result.size()][2];
		return result.toArray(array);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
		merge(intervals);
		System.out.println(intervals);
	}

}
