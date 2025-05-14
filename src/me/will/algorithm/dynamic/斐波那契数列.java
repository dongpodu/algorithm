package me.will.algorithm.dynamic;

/**
 * 斐波那契数列
 */
public class 斐波那契数列 {

    /**
     * 求第i个数的大小,i从0开始
     * <p>
     * 步骤：
     * 1、确定dp[i]含义：dp[i]代表第i个数的大小,i从0开始
     * 2、推导公式：dp[i]=dp[i-1]+dp[i-2]
     * 3、dp数组初始化：dp[0]=1,dp[1]=2
     * 4、遍历顺序：因为dp[i]=dp[i-1]+dp[i-2]，所以遍历是从前向后遍历
     * 5、举例：当i为8时，数组如下：0,1,1,2,3,5,8,13,21
     */
    public static int test(int i) {
        if (i <= 1) {
            return i;
        }
        int result = 0;
        int a = 0;
        int b = 1;
        for (int j = 2; j <= i; j++) {
            result = a + b;
            a = b;
            b = result;
            System.out.println(String.format("下标:%d,前第二个:%d,前第一个:%d,当前:%d", j, a, b, result));
        }
        return result;
    }

    public static void main(String[] args) {
        int s = test(8);
        System.out.println(s);
    }
}
