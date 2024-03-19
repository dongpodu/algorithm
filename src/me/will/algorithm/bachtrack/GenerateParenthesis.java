package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		dfs(n, 0, 0, "", result);
		return result;
	}

	private static void dfs(int n, int open, int close, String res, List<String> ans) {
		if (open > n || close > open) {
			return;
		}
		if (close + open == 2 * n) {
			ans.add(res);
		}
		dfs(n, open + 1, close, res + "(", ans);
		dfs(n, open, close + 1, res + ")", ans);
	}

	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		System.out.println(list);
	}
}
