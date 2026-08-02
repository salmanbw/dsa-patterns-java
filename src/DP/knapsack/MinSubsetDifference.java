package DP.knapsack;

import java.util.HashSet;
import java.util.Set;

public class MinSubsetDifference {

    public static void main(String[] args) {

        int[] arr = {1,2,7};
        int n = arr.length;
        int totalSum = 0;
        for(int i =0;i<n;i++)
            totalSum += arr[i];

        System.out.println("min subset difference "+minSubsetDiff(arr,totalSum, n));
    }

    public static int minSubsetDiff(int[] arr, int W, int n){

        boolean[][] dp = new boolean[n+1][W+1];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<=W;i++)
            dp[0][i] = false;

        for(int i=0;i<=n;i++)
            dp[i][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){

                if(arr[i-1] == j)
                    dp[i][j] = true;
                else if(arr[i-1] < j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];

                if(i==n && dp[i][j])
                    set.add(j);
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for(int num : set) {
            minDiff = Math.min(minDiff, Math.abs(W - 2*num));
            System.out.println("num -- " + num+"  mindifff -- " + minDiff);
        }
        System.out.println();
        return minDiff;
    }
}
