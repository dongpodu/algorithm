package me.will.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class MaxSubLength {

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
	public static int maxUnDuplicateSubStringLength(String s) {
		int max = 0;
		int left = 0;
		Map<Character, Integer> charMaxPosMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charMaxPosMap.containsKey(c)) {
				left = Math.max(left, charMaxPosMap.get(c) + 1);
			}
			charMaxPosMap.put(c, i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcbacd";
		int l = maxUnDuplicateSubStringLength(s);
		System.out.println(l);
	}
}
