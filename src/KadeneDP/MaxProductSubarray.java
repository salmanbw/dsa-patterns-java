package KadeneDP;

//Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
public class MaxProductSubarray {

    public static void main(String[] args) {

        int[] arr = {1,2,-3,0,-4,-5};
        int[] arr1 = {1,2,3,4,5,0};
        System.out.println(maxProductSubArray(arr));
        System.out.println(maxProductSubArray(arr1));
    }

    public static int maxProductSubArray(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i] == 0 || arr[i-1] ==0)
                dp[i] = arr[i];
            else
                dp[i] = dp[i-1]*arr[i] ;

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
