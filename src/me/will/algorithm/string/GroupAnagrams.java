package me.will.algorithm.string;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 */
public class GroupAnagrams {

	/**
	 * 排序法
	 *
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return Collections.emptyList();
		}
		Map<List<Character>, List<String>> map = new HashMap<>();
		for (String s : strs) {
			List<Character> key = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				key.add(s.charAt(i));
			}
			Collections.sort(key);

			map.computeIfAbsent(key, r -> new ArrayList<>()).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static List<List<String>> groupAnagrams1(String[] strs) {
		if (strs == null || strs.length == 0) {
			return Collections.emptyList();
		}
		Map<Key, List<String>> map = new HashMap<>();
		for (String s : strs) {
			Key key = new Key(s);
			map.computeIfAbsent(key, r -> new ArrayList<>()).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static class Key {
		Map<Character, Integer> map;

		public Key(String s) {
			map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				Character k = s.charAt(i);
				Integer c = map.get(k);
				if (c == null) {
					c = 0;
				}
				c += 1;
				map.put(k, c);
			}
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Key key = (Key) o;
			return Objects.equals(map, key.map);
		}

		@Override
		public int hashCode() {
			return Objects.hash(map);
		}
	}

	public static void main(String[] args) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams(strs);
		System.out.println(lists);
	}
}
