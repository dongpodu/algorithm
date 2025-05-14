package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 分割回文串 {

	//保持前几题一贯的格式， initialization
	List<List<String>> res = new ArrayList<>();
	List<String> cur = new ArrayList<>();

	/**
	 * https://programmercarl.com/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.html#%E6%80%9D%E8%B7%AF
	 */
	public List<List<String>> partition(String s) {
		backtracking(s, 0, new StringBuilder());
		return res;
	}

	private void backtracking(String s, int start, StringBuilder sb) {
		//因为是起始位置一个一个加的，所以结束时start一定等于s.length,因为进入backtracking时一定末尾也是回文，所以cur是满足条件的
		if (start == s.length()) {
			//注意创建一个新的copy
			res.add(new ArrayList<>(cur));
			return;
		}
		//像前两题一样从前往后搜索，如果发现回文，进入backtracking,起始位置后移一位，循环结束照例移除cur的末位
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (check(sb)) {
				cur.add(sb.toString());
				backtracking(s, i + 1, new StringBuilder());
				cur.remove(cur.size() - 1);
			}
		}
	}

	//helper method, 检查是否是回文
	private boolean check(StringBuilder sb) {
		for (int i = 0; i < sb.length() / 2; i++) {
			if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
