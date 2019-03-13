package me.will.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,1,4,7,5};
        sort(array);
        Arrays.stream(array).forEach(r -> System.out.println(r));
    }
}
