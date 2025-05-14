package me.will.algorithm.bachtrack;

/**
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 单词搜索 {

	/**
	 * https://blog.csdn.net/weixin_42638946/article/details/122002958
	 */
	int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (dfs(board, word.toCharArray(), 0, i, j))
					return true;
		return false;
	}

	// 从board[x][y]开始搜索word[u]
	private boolean dfs(char[][] board, char[] word, int u, int x, int y) {

		if (board[x][y] != word[u]) return false;
		if (u == word.length - 1) return true;

		char t = board[x][y];
		board[x][y] = '.';
		for (int i = 0; i < 4; i++) {
			int a = x + dx[i], b = y + dy[i];
			if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '.')
				continue;
			if (dfs(board, word, u + 1, a, b)) return true;
		}
		board[x][y] = t;
		return false;
	}


}
