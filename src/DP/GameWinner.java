package DP;

import java.util.Arrays;

public class GameWinner {

    public static void main(String[] args) {
        int[] arr = {1,5,2};
        int[] arr1 = {1,5,233,7};

        int n = arr1.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(predictWinner(arr1,0,3));
        System.out.println(memoizedWinner(arr1,0,3,dp));
    }

    public static int memoizedWinner(int[] arr, int i, int j, int[][] dp){

        if (i > j)
            return 0;

        if (i == j)
            return arr[i];

        if (i + 1 == j)
            return Math.max(arr[i], arr[j]);

        if (dp[i][j] != -1)
            return dp[i][j];

        int left = arr[i] + Math.min(memoizedWinner(arr, i + 2, j, dp), memoizedWinner(arr, i + 1, j - 1, dp));

        int right = arr[j] + Math.min(memoizedWinner(arr, i + 1, j - 1, dp), memoizedWinner(arr, i, j - 2, dp));

        return dp[i][j] = Math.max(left, right);
    }

    
    //Recursive approach for optimal game strategy
    public static int predictWinner(int[] arr, int i, int j){

        if(i>j)
            return 0;

        if(i==j)
            return arr[i];

        if(i+1 ==j)
            return Math.max(arr[i],arr[j]);

        int left = arr[i] + Math.min(predictWinner(arr,i+1,j-1), predictWinner(arr,i+2,j));

        int right = arr[j] + Math.min(predictWinner(arr,i+1,j-1), predictWinner(arr,i,j-2));

        return Math.max(left,right);
    }
}
