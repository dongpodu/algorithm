package me.will.algorithm.bachtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/submissions/629723128/?envType=study-plan-v2&envId=top-100-liked
 */
public class 电话号码的字母组合 {

	// 号码与字母的映射表
	String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	List<String> res = new LinkedList<>();

	/**
	 * https://blog.csdn.net/qyb19970829/article/details/113794586
	 *
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return res;
		dfs(digits, new StringBuilder(), 0);
		return res;
	}

	public void dfs(String digits, StringBuilder sb, int depth) {
		if (depth == digits.length()) {
			res.add(sb.toString());
			return;
		}
		// 找到对应的电话号码
		int number = digits.charAt(depth) - '0';
		// 找到对应号码的字符串
		String str = letter_map[number];

		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			dfs(digits, sb, depth + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}


}
