package me.will.algorithm.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Duplicate {

    public static void findAnyDuplicate(int[] arr) {
        int d = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    d = arr[i];
                    break;
                } else if (arr[i] < i) {
                    d = arr[i];
                    break;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
                String str = Arrays.stream(arr)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(","));
                System.out.println("sorted array:" + str);
            } else {
                i++;
            }
        }
        System.out.println("duplicate:" + d);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 2, 1};
        findAnyDuplicate(arr);
    }
}
