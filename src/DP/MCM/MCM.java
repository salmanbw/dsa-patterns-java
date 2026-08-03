package DP.MCM;

public class MCM {

    static int[][] dp;

    public static void main(String[] args) {

        int[] arr = {40, 20, 50, 10, 30};
        int n = arr.length;
        System.out.println(recursiveMCM(arr,1,n-1));

        dp = new int[n][n];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        System.out.println(topDownMCM(arr,1,n-1));

        System.out.println(bottomUpTabulation(arr));
    }

    public static int bottomUpTabulation(int[] arr){

        int n = arr.length;
        int[][] dp1 = new int[n][n];

        for(int len=2;len < n;len++){

            for(int i = 1;i<= n-len;i++){

                int j = len + i -1;
                dp1[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int cost = dp1[i][k] + dp1[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    dp1[i][j] = Math.min(dp1[i][j], cost);
                }
            }
        }
        return dp1[1][n-1];
    }

    public static int topDownMCM(int[] arr, int i, int j){

        int min = Integer.MAX_VALUE;

        if(i >= j )
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        for(int k=i;k<=j-1;k++){

            int temp = topDownMCM(arr,i,k) + topDownMCM(arr, k+1,j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,temp);
        }
        dp[i][j] = min;
        return min;
    }

    public static int recursiveMCM(int[] arr, int i, int j){

        int min = Integer.MAX_VALUE;
        if(i >= j )
            return 0;

        for(int k=i;k<=j-1;k++){

            int temp = recursiveMCM(arr,i,k) + recursiveMCM(arr, k+1,j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,temp);
        }
        return min;
    }
}
