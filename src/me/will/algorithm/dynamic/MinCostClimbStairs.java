package me.will.algorithm.dynamic;

/**
 * https://programmercarl.com/0746.%E4%BD%BF%E7%94%A8%E6%9C%80%E5%B0%8F%E8%8A%B1%E8%B4%B9%E7%88%AC%E6%A5%BC%E6%A2%AF.html#%E6%80%9D%E8%B7%AF
 * 题目：给你一个整数数组cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯，求爬到第i台阶最小的费用
 */
public class MinCostClimbStairs {


    /**
     * 步骤：
     * 1、确定dp[i]含义：dp[i]代表爬到第i所需要的最小费用
     * 2、推导公式：爬到第i层台阶有两种方法，一是从i-1向上爬1个台阶，此时d[i]=dp[i-1]+cost[i-1]；
     * 二是从dp[i-2]向上爬两个台阶，此时cost[i]=dp[i-2]+cost[i-2]；而dp[i]要从这两个方法中选择最小花费的
     * 所以dp[i]=min((dp[i-1]+cost[i-1]),(dp[i-2]+cost[i-2]))
     * 3、如何初始化：因为可以从下标为0或者1的台阶开始，说明到0或者1的台阶不需要任何花费，所以dp[0]=dp[1]=0
     * 4、遍历顺序：从前向后遍历
     * 5、举例：比如cost数组为[0,0,1,2,2,3]
     * 1）上到第0台阶，总共需要0
     * 2）上到第1台阶，总共需要0
     * 3）上到第2台阶，总共需要min(0,0)=0
     * 4）上到第3台阶，总共需要min(dp[1]+cost[1]=0,dp[2]+cost[2]=1)=0
     */
    public int test(int i, int[] c) {
        if (i <= 1) {
            return 0;
        }
        int[] cost = new int[i];
        cost[0] = 0;
        cost[1] = 0;
        for (int j = 2; j <= i; j++) {
            cost[j] = Math.min(cost[j - 2] + c[j - 2], cost[j - 1] + c[j - 1]);
        }
        return cost[i];
    }
}
