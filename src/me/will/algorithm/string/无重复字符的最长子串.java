package me.will.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 */
public class 无重复字符的最长子串 {

	/**
	 * 找出字符串中不含重复字符的最大子串长度
	 * 使用滑动窗口
	 * 1、先从左找出一段不重复的子串，子串的起始位置设置为left，代表从left到i都不会有重复的，故最大长度max为i-left+1.
	 * 2、当继续往后走一位时发现此字符跟前面的有重复，遂将left设置为重复的字符位置（如果此位置小于left，则不变）
	 * 3、max始终取max和i-left+1中的最大值，目的就是为了只有i-left+1比max大时才替换
	 *
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		// 用来记录每个字符串最后出现的位置
		Map<Character, Integer> charMap = new HashMap<>();

		int max = 0;  // 最长的长度
		int left = 0;  // 当前字符串的左边
		// right 当前字符串的右边
		for (int right = 0; right < s.length(); right++) {
			char current = s.charAt(right);
			// 如果map中存在这个字符，则将left移动到charMap.get (current) + 1 的位置上，主要用来确保没有重复的字符出现
			if (charMap.containsKey(current)) {
				left = Math.max(charMap.get(current) + 1, left);
			}
			// 如果不存在这个字符，则放入到map中，
			charMap.put(current, right);
			// 计算这个子串的长度，并且取最大值
			max = Math.max(max, right - left + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		int l = lengthOfLongestSubstring("abba");
		System.out.println(l);
	}
}
