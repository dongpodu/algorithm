package me.will.algorithm.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 四数之和 {
    /**
     * 统计数组A、B、C、D中有多少种情况使得a+b+c+d=0
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int s = a + b;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int temp = -c - d;
                if (map.get(temp) != null) {
                    count += map.getOrDefault(temp, 0);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
