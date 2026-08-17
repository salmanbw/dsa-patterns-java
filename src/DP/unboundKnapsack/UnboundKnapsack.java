package DP.unboundKnapsack;

public class UnboundKnapsack {

    public static void main(String[] args) {

        int[] wt = {10, 20, 30};
        int[] val = {30, 100, 120};
        int W = 50;

        System.out.println(unboundedKnapsack(wt,val,W));
        System.out.println(recursiveUnbounded(wt, val, W, wt.length-1));
    }

    public static int unboundedKnapsack(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= W; j++)
            dp[0][j] = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static int recursiveUnbounded(int[] wt, int[] val, int W, int n){

        if(W ==0 || n < 0)
            return 0;

        if(wt[n] <= W)
            return Math.max(recursiveUnbounded(wt, val, W, n-1), val[n] + recursiveUnbounded(wt, val, W- wt[n], n));
        else
            return recursiveUnbounded(wt, val, W, n-1);

    }
}
