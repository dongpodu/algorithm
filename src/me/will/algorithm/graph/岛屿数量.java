package me.will.algorithm.graph;

/**
 * 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/
 * https://www.bilibili.com/video/BV1Tr4y1K7bA/?spm_id_from=333.337.search-card.all.click&vd_source=8f639406d19c6729b8f6eea502c54875
 *
 */
public class 岛屿数量 {

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	public static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
}
