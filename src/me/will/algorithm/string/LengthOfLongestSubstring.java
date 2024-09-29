package me.will.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		// 用来记录每个字符串最后出现的位置
		Map<Character, Integer> charMap = new HashMap<>();

		int left = 0;  // 当前字符串的左边
		int max = 0;  // 最长的长度
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
