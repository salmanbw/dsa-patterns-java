package DP.unboundKnapsack;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {
        int[] arr = {2, 4,10};
        int amount = 10;
        System.out.println(recursiveChange(arr, arr.length-1, amount));

        int[] arr1 = {1,2,3};
        int amount1 = 4;
        System.out.println(recursiveChange(arr1,arr1.length-1,amount1));


        int[][] dp = new int[arr.length+1][amount+1];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(dp[i], -1);

        System.out.println(memoizedChange(arr,arr.length-1,amount,dp));

    }

    public static int memoizedChange(int[] arr, int n, int amount, int[][] dp){
        if(amount ==0)
            return 1;

        if(n <0)
            return 0;

        if(dp[n][amount] != -1)
            return dp[n][amount];

        if(arr[n] <= amount){
            dp[n][amount] = recursiveChange(arr,n-1,amount) + recursiveChange(arr, n, amount - arr[n]);
        }else
            dp[n][amount] =  recursiveChange(arr,n-1,amount);

        return dp[n][amount];
    }

    public static int recursiveChange(int[] arr, int n, int amount){

        if(amount ==0)
            return 1;

        if(n <0)
            return 0;

        if(arr[n] <= amount){
            return recursiveChange(arr,n-1,amount) + recursiveChange(arr, n, amount - arr[n]);
        }else
            return recursiveChange(arr,n-1,amount);
    }


}
