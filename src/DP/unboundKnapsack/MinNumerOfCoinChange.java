package DP.unboundKnapsack;

import java.util.Arrays;

public class MinNumerOfCoinChange {

    static int INF = (int)1e9;
    public static void main(String[] args) {

        int[] arr = {2, 4,10};
        int amount = 8;
        int n = arr.length;


        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);

        int total = optimizedChange(arr,n-1,amount,dp);
        int result =0;
        if(total == 1000000)
             result = -1;
        else
            result = total;

        System.out.println(result);
    }

    public static int optimizedChange(int[] arr, int n, int amount, int[][] dp){

        if(amount == 0)
            return 0;

        if(n < 0)
            return 1000000;

        if(dp[n][amount] != -1)
            return dp[n][amount];

        if(arr[n] <= amount)
            dp[n][amount] = Math.min(change(arr,n-1,amount), 1 + change(arr,n,amount-arr[n]));
        else
            dp[n][amount] = change(arr,n-1,amount);

        return dp[n][amount];

    }

    public static  int change(int[] arr,int n,int amount){

        if(amount == 0)
            return 0;

        if(n < 0)
            return 1000000;

        if(arr[n] <= amount)
            return Math.min(change(arr,n-1,amount), 1 + change(arr,n,amount-arr[n]));
        else
            return change(arr,n-1,amount);
    }
}
