package me.will.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 腐烂的橘子 {

	int fresh = 0, minute = 0;
	Deque<int[]> deque = new ArrayDeque();

	/**
	 * https://cloud.tencent.com/developer/article/2296047
	 *
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) deque.addLast(new int[]{i, j});
				if (grid[i][j] == 1) fresh++;
			}
		}
		while (fresh > 0 && !deque.isEmpty()) {
			minute++;
			int nums = deque.size();
			for (int i = 0; i < nums; i++) {
				int[] cell = deque.removeFirst();
				int x = cell[0], y = cell[1];
				rot(grid, x - 1, y); // 查看上方单元格
				rot(grid, x + 1, y); // 查看下方单元格
				rot(grid, x, y - 1); // 查看左侧单元格
				rot(grid, x, y + 1); // 查看右侧单元格
			}
		}
		return fresh > 0 ? -1 : minute;
	}

	public void rot(int[][] grid, int x, int y) {
		if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
			grid[x][y] = 2;
			deque.addLast(new int[]{x, y});
			fresh--;
		}
	}

}
