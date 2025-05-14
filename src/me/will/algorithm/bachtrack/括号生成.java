package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/
 */
public class 括号生成 {

	/**
	 * https://www.cnblogs.com/GarrettWale/p/15778171.html
	 * https://www.cxyxiaowu.com/6469.html
	 *
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		dfs(n, 0, 0, "", result);
		return result;
	}

	/**
	 * @param n      有n对括号
	 * @param open   左边括号数
	 * @param close  右边括号数
	 * @param path   拼接的字符串
	 * @param result
	 */
	private static void dfs(int n, int open, int close, String path, List<String> result) {
		// 因为是递归函数，所以先写递归终止条件
		if (open > n || close > open) {
			return;
		}
		//收集结果
		if (open == n && close == n) {
			result.add(path);
			return;
		}
		// 如果左括号还没凑够，继续凑
		dfs(n, open + 1, close, path + "(", result);
		// 左括号数要大于右括号才能继续增加右括号
		if (open > close) {
			dfs(n, open, close + 1, path + ")", result);
		}
	}

	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		System.out.println(list);
	}
}
