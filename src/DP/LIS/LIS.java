package DP.LIS;

/*
Problem Statement: Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3, 6, 2, 7] is a subsequence of [0, 3, 1, 6, 2, 2, 7].
The task is to find the length of the longest subsequence in which every element is greater than the previous one.
 Note: In this article, we will solve the problem of the longest-increasing subsequence using binary search.

 Longest Decreasing Subsequence is just change the if condition - if(arr[i] > arr[j]) to if(arr[i] < arr[j])
*/
public class LIS {
    public static void main(String[] args) {

        int[] arr = {3,4,-1,0,6,2,3,1};
        System.out.println(LIS(arr));
    }

    public static int LIS(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        int max = 1;

        for(int i=0;i<n;i++)
            dp[i] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
