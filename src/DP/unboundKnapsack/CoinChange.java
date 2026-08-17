package DP.unboundKnapsack;

public class CoinChange {
    public static void main(String[] args) {

        int[] arr = {2, 4,10};
        int[] arr1 = {1,2,5};
        int sum = 11;
        System.out.println(recursiveCoinChange(arr1,sum, arr1.length));

    }

    public static int recursiveCoinChange(int[] arr, int W, int n){

        if(n==0 || W==0)
            return 0;

        if(arr[n-1] == W)
            return 1 + recursiveCoinChange(arr, W, n-1);

        if(arr[n-1] < W)
            return recursiveCoinChange(arr,W, n-1) + recursiveCoinChange(arr, W-arr[n-1], n);
        else
            return recursiveCoinChange(arr, W, n-1);
    }

    public static int coinChange(int[] arr, int sum){


        return -1;
    }
}
