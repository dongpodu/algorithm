package me.will.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbStairs {

	/**
	 * 求i个台阶有多少种爬方式，每次可以爬1个或2个台阶
	 * 步骤：
	 * 1、确定dp[i]含义：dp[i]代表爬i个台阶的方法数,i从1开始
	 * 2、推导公式：假设爬n-2有d[n-2]个方法，爬n-1有d[n-1]个方法，而从n-2爬到n只需要一次跨两个台阶（不能分两次，每次跨一个，因为这种方式已经统计在d[i-1]中了）
	 * ，从n-1爬到n只需要再跨一个台阶，所以dp[i]=dp[i-2]+dp[i-1]，这其实就是斐波那契数列
	 * 3、dp数组初始化：dp[1]=1,dp[2]=2
	 * 4、遍历顺序：因为dp[i]=dp[i-1]+dp[i-2]，所以遍历是从前向后遍历
	 * 5、举例：当i为8时，数组如下：1,2,3,5,8,13,21,34
	 *
	 * @param i
	 * @return
	 */
	public static int test(int i) {
		if (i <= 2) {
			return i;
		}
		int d = 0;
		int d_2 = 1;
		int d_1 = 2;
		for (int j = 3; j <= i; j++) {
			d = d_2 + d_1;
			d_2 = d_1;
			d_1 = d;
			System.out.println(String.format("下标:%d,前第二个:%d,前第一个:%d,当前:%d", j, d_2, d_1, d));
		}
		return d;
	}

	public static void main(String[] args) {
		int s = test(8);
		System.out.println(s);
	}
}
