package me.will.algorithm.array;

/**
 * 不懂
 */
public class ContinuousArray {

    /**
     * 给定一个数组，找到连续子数组和的最大值
     *
     * @param array
     * @return
     */
    public static int findSumMax(int[] array) {
        int result = array[0];
        int sum = array[0];
        for (int num : array) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, -5, 4, 6};
        int sum = findSumMax(array);
        System.out.println(sum);
    }
}
