package DP.LIS;

public class MaximumSumIncreasingSubseq {

    public static void main(String[] args) {
        int[] arr = {3,4,-1,0,6,2,3};
        System.out.println(maxSumIncreasingSubSeq(arr));
    }

    public static int maxSumIncreasingSubSeq(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;

        for(int i=0;i<n;i++)
            dp[i] = arr[i];

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
