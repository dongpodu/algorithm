package me.will.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    /**
     * 找到第一个不重复的字符
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer val = map.get(s.charAt(i));
            map.put(s.charAt(i), (val == null) ? 1 : ++val);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        int[] times = new int[256];
        for (char c : s.toCharArray()) {
            times[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (times[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstUniqChar(s);
        System.out.println(index);
    }
}
