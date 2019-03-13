package me.will.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void sort(int[] array){
        int temp;
        for(int i=1;i<array.length;i++){
            temp = array[i];
            for(int j=i;j>=0;j--){
                if(j-1>=0 && array[j-1]>temp){
                    array[j] = array[j-1];
                }else{
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,1,4,7,5,5,7};
        sort(array);
        Arrays.stream(array).forEach(r -> System.out.println(r));
    }
}
