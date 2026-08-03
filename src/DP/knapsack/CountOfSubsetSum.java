package DP.knapsack;

public class CountOfSubsetSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int target = 0;
        int n = arr.length;
        System.out.println(recursiveSubsetSum(arr, target, n));
        System.out.println(subsetSumDP(arr,target,n));
    }

    public static int subsetSumDP(int[] arr, int W, int n){

        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=W;i++)
            dp[0][i] = 0;

        for(int i=0;i<=n;i++)
            dp[i][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){

                if(arr[i-1] == j)
                    dp[i][j] = 1 + dp[i-1][j];
                else if(arr[i-1] < j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }


    public static int recursiveSubsetSum(int[] arr, int W, int n){

        if(n==0 || W==0)
            return 0;

        if(arr[n-1] == W)
            return 1 + recursiveSubsetSum(arr, W, n-1);

        if(arr[n-1] < W)
            return recursiveSubsetSum(arr,W, n-1) + recursiveSubsetSum(arr, W-arr[n-1], n-1);
        else
            return recursiveSubsetSum(arr, W, n-1);
    }
}
