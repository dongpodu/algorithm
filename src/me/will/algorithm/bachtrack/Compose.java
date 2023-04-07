package me.will.algorithm.bachtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compose {
    private Stack<Integer> compose = new Stack<>();
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 从1....n中取取出k个数作为一个组合，计算这样的组合有多少
     */
    public void backTracking(int n, int k, int startIndex) {
        if (compose.size() == k) {
            result.add(new ArrayList<>(compose));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            compose.add(i);
            backTracking(n, k, i + 1);
            compose.pop();
        }
    }

    public static void main(String[] args) {
        Compose c = new Compose();
        c.backTracking(5, 2, 0);
        System.out.println(c.result);
    }
}
