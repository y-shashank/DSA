package com.company.dynamicprogramming;

import java.util.Arrays;

// https://www.youtube.com/watch?v=o_AJ3VWQMzA
public class EggDroping {
    public int process(int floors, int eggs){
        // to cover edge case we make + 1 larger 2d matrix Floor * Eggs
        int[][] dp = new int[floors + 1][eggs + 1];

        // base conditions if you have N floors and 1 egg it will take N attempts because we need to check 1 floor at a time
        for(int i = 0; i < floors + 1; i++){
            dp[i][1] = i;
        }
        // base condition if you have 1 floor and K eggs it will only take 1 attempt, number of eggs dont matter
        for(int i = 1; i < eggs + 1; i++){
            dp[1][i] = 1;
        }

        for(int n = 2; n < floors+1; n++){
            for (int e = 2; e < eggs+1; e++){
                dp[n][e] = Integer.MAX_VALUE;
                for(int x = 1; x <= n -1; x++) {
                    int eggBroken = dp[n-x][e-1];
                    int eggNotBroken = dp[x-1][e];
                    dp[n][e] = Math.min(dp[n][e], Math.max(eggBroken, eggNotBroken) + 1);
                }
            }
        }
//        for (final int[] a : dp) {
//            System.out.println(Arrays.toString(a));
//        }
        return dp[floors][eggs];
    }
}
