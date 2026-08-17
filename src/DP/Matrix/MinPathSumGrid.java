package DP.Matrix;

public class MinPathSumGrid {

    public static void main(String[] args) {

        int[][] grid = {{5,9,6},{11,5,2}};
        System.out.println(minSum(grid,1,2));

        int m =1, n=2;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }


        System.out.println(minSumMem(grid,dp,m,n));
        System.out.println(dp[0][0]);

    }

    public static int minSum(int[][] arr, int m, int n){

        if(m <0 || n <0)
            return Integer.MAX_VALUE;

        if(m==0 && n==0)
            return arr[m][n];

        return arr[m][n] + Math.min(minSum(arr,m-1,n), minSum(arr,m,n-1));
    }

    public static int minSumMem(int[][] arr, int[][] dp, int m, int n){
        if(m <0 || n <0)
            return Integer.MAX_VALUE;

        if(m==0 && n==0)
            return arr[m][n];

        if(dp[m][n] != -1)
            return dp[m][n];

        dp[m][n] = arr[m][n] + Math.min(minSum(arr,m-1,n), minSum(arr,m,n-1));
        return dp[m][n];
    }
}
