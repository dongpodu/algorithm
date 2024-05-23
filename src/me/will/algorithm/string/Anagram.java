package me.will.algorithm.string;

/**
 * 判断两个字符串是否为异位字符串（仅包含小写字母）
 * https://leetcode.cn/problems/valid-anagram/description/
 */
public class Anagram {
	/**
	 * 将字符作为数组的下标，里面的值代表字符出现的次数
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] times = new int[26];
		for (char c : s.toCharArray()) {
			//两字符相减=两字符转的ASCII码相减
			times[c - 'a']++;
		}
		int[] times1 = new int[26];
		for (char c : t.toCharArray()) {
			times1[c - 'a']++;
		}

		for (int i = 0; i < times.length; i++) {
			if (times[i] != times1[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] array = new int[26];
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}

		for (int a : array) {
			if (a != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		System.out.println(isAnagram(s, t));
	}
}
