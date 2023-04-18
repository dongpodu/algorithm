package me.will.algorithm.dynamic;

import javax.rmi.CORBA.Util;

/**
 * https://programmercarl.com/0062.%E4%B8%8D%E5%90%8C%E8%B7%AF%E5%BE%84.html#%E6%80%9D%E8%B7%AF
 */
public class Road {

    public static int test(int m, int n) {
        int[][] dd = new int[m][n];
        for (int i = 0; i < m; i++) {
            dd[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dd[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dd[i][j] = dd[i][j - 1] + dd[i - 1][j];
                System.out.println(String.format("行走到[%d,%d]有%d种方法", i, j, dd[i][j]));
            }
        }
        return dd[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int count = test(10, 3);
        System.out.println(count);
    }
}
