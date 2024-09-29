package me.will.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class Merge {

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] pre = intervals[i];
			if (i == intervals.length - 1) {
				list.add(pre);
				break;
			}
			int[] post = intervals[i + 1];
			if (pre[1] < post[0]) {
				list.add(pre);
			} else if (pre[1] < post[1]) {
				int[] interval = new int[] {pre[0], post[1]};
				intervals[i] = null;
				intervals[i + 1] = interval;
			} else {
				int[] interval = {pre[0], pre[1]};
				intervals[i] = null;
				intervals[i + 1] = interval;
			}
		}
		int[][] array = new int[list.size()][2];
		return list.toArray(array);
	}

	public int[][] merge1(int[][] intervals) {
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
			int[] post = intervals[i + 1];
			if (curr[1] < post[0]) {
				result.add(curr);
			} else if (curr[1] <= post[1]) {
				post[0] = curr[0];
			} else {
				post[0] = curr[0];
				post[1] = curr[1];
			}
		}
		int[][] array = new int[result.size()][2];
		return result.toArray(array);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {new int[] {1, 3}, new int[] {2, 6}, new int[] {8, 10}, new int[] {15, 18}};
		merge(intervals);
		System.out.println(intervals);
	}

}
