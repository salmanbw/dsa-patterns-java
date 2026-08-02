package DP.knapsack;

public class Knapsack01 {

    public static void main(String[] args) {

        int[] wt = {10, 20, 30};
        int[] val = {30, 100, 120};
        int W = 50;

        System.out.println(knapsack(wt, val, W));
        System.out.println(recursiveKnapsack(wt,val,W, wt.length));

    }

    public static int recursiveKnapsack(int[] wt, int[] val, int W, int n){

        if(W == 0 || n ==0)
            return 0;

        if(wt[n-1] <= W){
            return Math.max(recursiveKnapsack(wt,val,W,n-1), val[n-1] + recursiveKnapsack(wt,val, W-wt[n-1], n-1));
        }

        return recursiveKnapsack(wt, val, W, n-1);
    }

    public static int knapsack(int[] wt, int[] val, int W){

        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++)
            dp[i][0] = 0;

        for(int j=0;j<=W;j++)
            dp[0][j] = 0;


        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){

                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}
