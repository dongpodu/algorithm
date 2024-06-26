package me.will.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			String sub = s.substring(i, i + p.length());
			boolean f = Anagram.isAnagram(sub, p);
			if (f) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "abab", p = "ab";
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);
	}

}
