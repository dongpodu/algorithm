package me.will.algorithm.string;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
		String tmp = null;
		//假设s减去i个字符后是回文子串
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				tmp = s.substring(j, j + s.length() - i);
				if (isPalindrome(tmp)) {
					return tmp;
				}
			}
		}
		return tmp;
	}

	public static boolean isPalindrome(String s) {
		int j = s.length() - 1;
		for (int i = 0; i < j; i++, j--) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (a != b) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "babad";
		String result = longestPalindrome(s);
		System.out.println(result);
	}
}
