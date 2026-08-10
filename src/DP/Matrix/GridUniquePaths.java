package DP.Matrix;

public class GridUniquePaths {

    public static void main(String[] args) {

        int m = 4, n=2;
        int m1 = 3, n1=2;
        System.out.println(countPaths(m-1,n-1));

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        //System.out.println(countPathMem(dp,m-1,n-1));
        System.out.println(countPathMem(dp,m1-1,n1-1));

    }

    public static int countPaths(int m, int n){

        if(m <0 || n <0)
            return 0;
        if(m==0 && n==0)
            return 1;
        return countPaths(m-1,n) + countPaths(m,n-1);
    }

    public static int countPathMem(int[][] dp,int m, int n){

        if(m<0 || n<0)
            return 0;

        if(m==0 && n==0)
            return 1;

        if(dp[m][n] != -1)
            return dp[m][n];

        return countPathMem(dp,m,n-1) + countPathMem(dp,m-1,n);

    }
}
