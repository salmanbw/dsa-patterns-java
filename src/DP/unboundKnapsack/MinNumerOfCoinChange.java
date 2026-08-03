package DP.unboundKnapsack;

public class MinNumerOfCoinChange {

    static int INF = (int)1e9;
    public static void main(String[] args) {

        int[] arr = {2, 4,10};
        int sum = 8;
        System.out.println(recursiveMinCoinChange(arr,sum, arr.length));
    }

    public static int minCoins(int[] arr, int sum, int n) {
        // Amount formed
        if(sum == 0)
            return 0;

        // No coins left
        if(n == 0)
            return INF;

        // Take or skip
        if(arr[n-1] <= sum) {

            int take = 1 + minCoins(arr, sum - arr[n-1], n);
            int notTake = minCoins(arr, sum, n-1);

            return Math.min(take, notTake);
        }

        return minCoins(arr, sum, n-1);
    }

    public static int recursiveMinCoinChange(int[] arr, int W, int n){

        if(n==0)
            return Integer.MAX_VALUE;

        if(W==0)
            return 1;

        if(arr[n-1] == W)
            return 1;

        if(arr[n-1] < W)
            return Math.min(recursiveMinCoinChange(arr,W, n-1) , 1 + recursiveMinCoinChange(arr, W-arr[n-1], n));
        else
            return recursiveMinCoinChange(arr, W, n-1);
    }
}
