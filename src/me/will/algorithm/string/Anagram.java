package me.will.algorithm.string;

public class Anagram {
    /**
     * 判断两个字符串是否为异位字符串
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] times = new int[256];
        for (char c : s.toCharArray()) {
            times[c - 'a']++;
        }
        int[] times1 = new int[256];
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

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }
}
