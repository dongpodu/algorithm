package me.will.algorithm.string;

import java.util.*;

/**
 *
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList();
		}
		Map<Key, List<String>> map = new HashMap<>();
		for (String s : strs) {
			Key key = new Key(s);
			List<String> list = map.get(key);
			if (list == null) {
				list = new ArrayList();
			}
			list.add(s);
			map.put(key, list);
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
		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
		List<List<String>> lists = groupAnagrams(strs);
		System.out.println(lists);
	}
}
