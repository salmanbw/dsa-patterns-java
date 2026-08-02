package DP.MCM;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "nitip";
        System.out.println(isPalindrome(s,0,4));
        System.out.println(recursivePalindromeMCM(s,0,4));
        System.out.println(bottomUpPalindromeMCM(s));

    }

    public static int bottomUpPalindromeMCM(String s){

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int len=1;len<=n;len++){

            for(int i=0;i<=n-len;i++){

                int j = len+i-1;
                dp[i][j] = Integer.MAX_VALUE;

                if(isPalindrome(s,i,j)) {
                    dp[i][j] = 0;
                    continue;
                }

                for(int k=i;k<j;k++){
                    int cut = 1 + dp[i][k] + dp[k+1][j];
                    dp[i][j] = Math.min(dp[i][j], cut);
                }
            }
        }
        return dp[0][n-1];
    }

    public static int recursivePalindromeMCM(String s, int i, int j){

        if(i >= j)
            return 0;

        if(isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){

            int temp = 1 + recursivePalindromeMCM(s,i,k) + recursivePalindromeMCM(s, k+1,j);
            min = Math.min(temp, min);
        }
        return min;

    }

    public static boolean isPalindrome(String s, int i, int j){

        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
