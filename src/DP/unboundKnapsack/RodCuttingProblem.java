package DP.unboundKnapsack;

public class RodCuttingProblem {

    public static void main(String[] args) {

        int[] arr = {1, 6, 8, 9, 10, 19, 7, 20};
        int length = 8;

        int[] arr1 = {1, 5, 8, 9};
        int length1 = 4;

        System.out.println("1 solution -- "+recursiveRod(arr,length,arr.length));
        System.out.println("2 solution -- "+recursiveRod(arr1,length1,arr1.length));
        System.out.println("DP solution -- "+dpRod(arr,length));
        System.out.println("DP solution 2-- "+dpRod(arr1,length1));

        System.out.println("recursive -- "+recursiveRodCutting(arr,length,length));
    }

    public static int recursiveRodCutting(int[] arr, int n, int length){

        if(length ==0 || n ==0)
            return 0;

        if(n <= length)
            return Math.max(recursiveRodCutting(arr, n-1,length), arr[n-1] + recursiveRodCutting(arr, n, length-n));
        else
            return recursiveRodCutting(arr, n-1,length);
    }

    public static int recursiveRod(int[] arr, int W, int n){

        if(n==0 || W ==0)
            return 0;

        if(n <= W)
            return Math.max(recursiveRod(arr,W,n-1), arr[n-1] + recursiveRod(arr,W-n,n));
        else
            return recursiveRod(arr,W,n-1);
    }

    public static int dpRod(int[] arr, int W) {

        int n = arr.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= W; j++)
            dp[0][j] = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (i <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
