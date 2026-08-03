package DP.OptimalGame;

/*
Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.
The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.
Input: stoneValue = [1,2,3,7]
Output: "Bob"

 */
public class StoneGameIII {

    public static void main(String[] args) {

        int[] arr = {1,2,3,7};
        System.out.println(stoneGameIII(arr));

    }

    public static String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1;i>=0;i--){

            int sum =0;
            dp[i] = Integer.MIN_VALUE;
            for(int j=1;j<=3 && i+j-1 <n ;j++){
                sum = sum + stoneValue[i+j-1];
                dp[i] = Math.max(dp[i], sum - dp[i+j]);
            }
        }

        if(dp[0] > 0)
            return "Alice";
        else if(dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}
