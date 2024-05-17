package me.will.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int max = 0;
		Map<Character, Integer> positionMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer p = positionMap.get(c);
			if (p != null) {
				left = Math.max(left, p + 1);
			}
			positionMap.put(c, i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		int l = lengthOfLongestSubstring("abba");
		System.out.println(l);
	}
}
