package DP.unboundKnapsack;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {

        int n = 13;
        int val = minSquaresDP(n);
        System.out.println(val);
    }

    public static int minSquaresDP(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);

        dp[0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j*j <=i;j++){
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
    }


}
