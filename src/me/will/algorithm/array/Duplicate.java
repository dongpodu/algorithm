package me.will.algorithm.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Duplicate {

    /**
     * 数组的长度是n，数组内的数字在0-n-1范围内，找出这个数组中任意一对重复数字
     *
     * @param arr
     */
    public static void findAnyDuplicate(int[] arr) {
        int d = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] != i) { //循环调换，直到arr[i]==i才往下比较下一个数
                if (arr[i] == arr[arr[i]]) {
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
        int[] arr = new int[]{3, 3, 1, 4, 1};
        findAnyDuplicate(arr);
    }
}
